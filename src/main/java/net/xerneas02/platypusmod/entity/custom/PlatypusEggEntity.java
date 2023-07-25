package net.xerneas02.platypusmod.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.xerneas02.platypusmod.entity.ModEntity;
import net.xerneas02.platypusmod.item.ModItems;

public class PlatypusEggEntity extends ThrowableItemProjectile {
    public PlatypusEggEntity(EntityType entityType, Level level) {
        super(entityType, level);
    }

    public PlatypusEggEntity(Level worldIn, LivingEntity throwerIn) {
        super(ModEntity.PLATYPUS_EGG.get(), throwerIn, worldIn);
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int lvt_2_1_ = 1;
                if (this.random.nextInt(32) == 0) {
                    lvt_2_1_ = 4;
                }
                for (int lvt_3_1_ = 0; lvt_3_1_ < lvt_2_1_; ++lvt_3_1_) {
                    PlatypusEntity lvt_4_1_ = ModEntity.PLATYPUS.get().create(this.level);
                    lvt_4_1_.setAge(-24000);
                    lvt_4_1_.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level.addFreshEntity(lvt_4_1_);
                }
            }
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }

    }

    protected Item getDefaultItem() {
        return ModItems.PLATYPUS_EGG.get();
    }
}