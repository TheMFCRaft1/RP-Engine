
package com.themfcraft.rpengine.block;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.StateContainer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import io.netty.buffer.Unpooled;

import com.themfcraft.rpengine.world.inventory.CreateidcardMenu;
import com.themfcraft.rpengine.block.entity.IdCardMakerBlockEntity;

public class IdCardMakerBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<AttachFace> FACE = HorizontalFaceBlock.FACE;

	public IdCardMakerBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build()).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING, FACE);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(FACE, faceForDirection(context.getNearestLookingDirection())).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
		super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayerEntity) {
			NetworkHooks.openGui(((ServerPlayerEntity) entity), new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent("Id Card Maker");
				}

				@Override
				public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
					return new CreateidcardMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		return tileEntity instanceof INamedContainerProvider ? ((INamedContainerProvider) tileEntity) : null;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new IdCardMakerBlockEntity();
	}

	@Override
	public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
		super.eventReceived(state, world, pos, eventID, eventParam);
		TileEntity blockEntity = world.getTileEntity(pos);
		return blockEntity == null ? false : blockEntity.receiveClientEvent(eventID, eventParam);
	}

	@Override
	public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity blockEntity = world.getTileEntity(pos);
			if (blockEntity instanceof IdCardMakerBlockEntity) {
				InventoryHelper.dropInventoryItems(world, pos, ((IdCardMakerBlockEntity) blockEntity));
				world.updateComparatorOutputLevel(pos, this);
			}
			super.onReplaced(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof IdCardMakerBlockEntity)
			return Container.calcRedstoneFromInventory(((IdCardMakerBlockEntity) tileentity));
		else
			return 0;
	}
}
