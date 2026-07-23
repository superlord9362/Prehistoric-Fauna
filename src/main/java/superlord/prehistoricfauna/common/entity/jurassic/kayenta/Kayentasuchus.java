package superlord.prehistoricfauna.common.entity.jurassic.kayenta;


public class Kayentasuchus  {
//	private int maxHunger = 10;
//	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Kayentasuchus.class, EntityDataSerializers.BOOLEAN);
//	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Kayentasuchus.class, EntityDataSerializers.BOOLEAN);
//	public static final EntityDataAccessor<Integer> SIT_TICK = SynchedEntityData.defineId(Kayentasuchus.class, EntityDataSerializers.INT);
//	private float sitProgress = 0.0F;
//	private float prevSitProgress = 0.0F;
//
//	public Kayentasuchus(EntityType<? extends Kayentasuchus> type, Level level) {
//		super(type, level);
//		this.setMaxUpStep(1.375F);
//		super.maxHunger = maxHunger;
//	}
//
//	public boolean isTameSitting() {
//		return this.entityData.get(TAME_SIT);
//	}
//
//	private void setTameSitting(boolean isTameSitting) {
//		this.entityData.set(TAME_SIT, isTameSitting);
//		this.entityData.set(SIT_TICK, 15);
//	}
//
//	public boolean isTameWandering() {
//		return this.entityData.get(TAME_WANDER);
//	}
//
//	private void setTameWandering(boolean isTameWandering) {
//		this.entityData.set(TAME_WANDER, isTameWandering);
//	}
//
//	public boolean isFood(ItemStack stack) {
//		return stack.getItem() == PFItems.RAW_SMALL_THYREOPHORAN_MEAT.get();
//	}
//
//	protected void defineSynchedData() {
//		super.defineSynchedData();
//		this.entityData.define(TAME_SIT, false);
//		this.entityData.define(TAME_WANDER, false);
//		this.entityData.define(SIT_TICK, 0);
//	}
//
//	protected void registerGoals() {
//		super.registerGoals();
//		this.goalSelector.addGoal(0, new FloatGoal(this));
//		this.targetSelector.addGoal(4, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
//			return p_213487_1_.getType().is(PFTags.KAYENTASUCHUS_HUNTING);
//		}));
//		this.goalSelector.addGoal(1, new Kayentasuchus.MeleeAttackGoal());
//		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
//		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
//		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
//		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
//		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
//		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
//		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
//		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
//		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
//		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
//		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
//			return p_213487_0_.getType().is(PFTags.KAYENTASUCHUS_AVOIDING);
//		}));
//		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
//		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
//		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
//		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
//		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
//			return p_213487_1_.getType().is(PFTags.KAYENTASUCHUS_HUNTING);
//		}));
//		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
//			return p_213487_1_.getType().is(PFTags.KAYENTASUCHUS_BABY_HUNTING);
//		}));
//		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
//		this.targetSelector.addGoal(0, new DinosaurOwnerHurtByTargetGoal(this));
//		this.targetSelector.addGoal(0, new DinosaurOwnerHurtTargetGoal(this));
//		this.goalSelector.addGoal(0, new KayentasuchusFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
//		this.goalSelector.addGoal(4, new KayentasuchusBreakWebsGoal(1, 8, 2));
//	}
//
//	@SuppressWarnings("deprecation")
//	public InteractionResult mobInteract(Player player, InteractionHand hand) {
//		ItemStack itemstack = player.getItemInHand(hand);
//		Item item = itemstack.getItem();
//		if (item instanceof PaleopediaItem) {
//			CompoundTag tag = itemstack.getTag();
//			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
//			if (!already.contains(EnumPaleoPages.KAYENTASUCHUS.ordinal())) {
//				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.KAYENTASUCHUS.ordinal()), itemstack);
//				player.displayClientMessage(Component.translatable("paleopedia.kayentasuchus_added"), true);
//				return InteractionResult.SUCCESS;
//			} else {
//				player.displayClientMessage(Component.translatable("paleopedia.kayentasuchus_already_added"), true);
//				return InteractionResult.SUCCESS;
//			}
//		}
//		if (this.level().isClientSide()) {
//			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
//			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
//
//		} else {
//			if (this.isTame()) {
//				if (this.getCurrentHunger() < this.maxHunger && (itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.MEATS_6_HUNGER) || itemstack.is(PFTags.MEATS_8_HUNGER) || itemstack.is(PFTags.MEATS_10_HUNGER) || itemstack.is(PFTags.MEATS_12_HUNGER))) {
//					if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
//						if (this.getCurrentHunger() + 2 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 2);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//					if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
//						if (this.getCurrentHunger() + 4 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 4);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//					if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
//						if (this.getCurrentHunger() + 6 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 6);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//					if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
//						if (this.getCurrentHunger() + 8 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 8);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//					if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
//						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 10);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//					if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
//						if (this.getCurrentHunger() + 12 >= this.maxHunger) {
//							this.setHunger(this.maxHunger);
//						} else {
//							this.setHunger(this.getCurrentHunger() + 12);
//						}
//						if (!player.isCreative()) {
//							itemstack.shrink(1);
//						}
//					}
//				} else {
//					player.displayClientMessage(Component.translatable("entity.prehistoricfauna.fullHunger"), true);
//				}
//				if (this.getOwner() == player) {
//					if (this.isFood(itemstack)) {
//						if (this.getHealth() < this.getMaxHealth()) {
//							if (!player.getAbilities().instabuild) {
//								itemstack.shrink(1);
//							}
//							this.heal((float)item.getFoodProperties().getNutrition());
//							return InteractionResult.SUCCESS;
//						} else {
//							if (this.canFallInLove()) {
//								this.setInLove(player);
//								if (!player.isCreative()) {
//									itemstack.shrink(1);
//								}
//							}
//						}
//					} else {
//						if (this.isTameSitting()) {
//							this.setTameSitting(false);
//							this.setTameWandering(true);
//							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.wandering"), true);
//						} else if(this.isTameWandering()) {
//							this.setTameWandering(false);
//							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.following"), true);
//						} else {
//							this.setTameSitting(true);
//							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.sitting"), true);
//						}
//					}
//				}
//			} else {
//				if (this.isFood(itemstack)) {
//					if (!player.getAbilities().instabuild) {
//						itemstack.shrink(1);
//					}
//
//					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
//						this.tame(player);
//						this.navigation.stop();
//						this.setTarget((LivingEntity)null);
//						this.setTameSitting(true);
//						this.level().broadcastEntityEvent(this, (byte)7);
//					} else {
//						this.level().broadcastEntityEvent(this, (byte)6);
//					}
//
//					return InteractionResult.SUCCESS;
//				}
//			}
//		}
//		return super.mobInteract(player, hand);
//	}
//
//	public void aiStep() {
//		super.aiStep();
//		if (this.isSleeping() || this.isAsleep() || this.isTameSitting()) {
//			this.jumping = false;
//			this.xxa = 0.0F;
//			this.zza = 0.0F;
//		}
//		boolean flag = this.isInWater();
//		if (flag || this.isSleeping()) {
//			this.setTameSitting(false);
//		}
//	}
//
//	public void tick() {
//		super.tick();
//		prevSitProgress = sitProgress;
//		if (this.entityData.get(SIT_TICK) > 0) {
//			this.entityData.set(SIT_TICK, this.entityData.get(SIT_TICK) - 1);
//			if (sitProgress < 1.0F) {
//				sitProgress = Math.min(sitProgress + 0.1F, 1.0F);
//			}
//		} else {
//			if (sitProgress > 0F) {
//				sitProgress = Math.max(sitProgress - 0.2F, 0.0F);
//			}
//		}
//		if (this.isTameSitting()  || this.isAsleep()) {
//			this.getNavigation().stop();
//		}
//	}
//
//	public float getSitProgress(float partialTick) {
//		return prevSitProgress + (sitProgress - prevSitProgress) * partialTick;
//	}
//
//	public void addAdditionalSaveData(CompoundTag compound) {
//		super.addAdditionalSaveData(compound);
//		compound.putBoolean("IsTamedSitting", this.isTameSitting());
//		compound.putBoolean("IsTamedWander", this.isTameWandering());
//	}
//
//	/**
//	 * (abstract) Protected helper method to read subclass entity data from NBT.
//	 */
//	public void readAdditionalSaveData(CompoundTag compound) {
//		super.readAdditionalSaveData(compound);
//		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
//		this.setTameWandering(compound.getBoolean("IsTamedWander"));
//	}
//
//	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
//		int temperment = random.nextInt(100);
//		if (temperment < 85) {
//			this.setSkittish(true);
//		} else {
//			this.setPassive(true);
//		}
//		this.setCarnivorous(true);
//		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
//	}
//
//	@Override
//	public void setAge(int age) {
//		super.setAge(age);
//		if (this.getAge() >= -24000 && this.getAge() < 0) {
//			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);
//		} else if(this.getAge() >= 0) {
//			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
//		}
//	}
//
//	public static AttributeSupplier.Builder createAttributes() {
//		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.FOLLOW_RANGE, 20);
//	}
//
//	protected SoundEvent getAmbientSound() {
//		return this.isAsleep() ? null : PFSounds.KAYENTASUCHUS_IDLE.get();
//	}
//
//	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
//		return PFSounds.KAYENTASUCHUS_HURT.get();
//	}
//
//	protected SoundEvent getDeathSound() {
//		return PFSounds.KAYENTASUCHUS_DEATH.get();
//	}
//
//	public boolean doHurtTarget(Entity entity) {
//		boolean flag = super.doHurtTarget(entity);
//		if (flag) {
//			this.doEnchantDamageEffects(this, entity);
//		}
//		return flag;
//	}
//
//	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
//		public MeleeAttackGoal() {
//			super(Kayentasuchus.this, 1.25D, true);
//		}
//
//		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
//			double d0 = this.getAttackReachSqr(enemy);
//			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
//				this.resetAttackCooldown();
//				this.mob.doHurtTarget(enemy);
//			} else if (distToEnemySqr <= d0 * 2.0D) {
//				if (this.isTimeToAttack()) {
//					this.resetAttackCooldown();
//				}
//			} else {
//				this.resetAttackCooldown();
//			}
//
//		}
//
//		public boolean canContinueToUse() {
//			return super.canContinueToUse();
//		}
//
//		public void stop() {
//			super.stop();
//		}
//
//		protected double getAttackReachSqr(LivingEntity attackTarget) {
//			return (double)(4.0F + attackTarget.getBbWidth());
//		}
//	}
//
//	@Override
//	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
//		Kayentasuchus entity = new Kayentasuchus(PFEntities.KAYENTASUCHUS.get(), this.level());
//		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
//		return entity;
//	}
//
//	@Override
//	public ItemStack getPickedResult(HitResult target) {
//		return new ItemStack(PFItems.KAYENTASUCHUS_SPAWN_EGG.get());
//	}
//
//	public Item getEggItem() {
//		return PFItems.KAYENTASUCHUS_EGG.get();
//	}
//
//	public BlockState getEggBlock(Level world, BlockPos pos) {
//		return PFBlocks.KAYENTASUCHUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
//	}
//
//	public class KayentasuchusFollowOwnerGoal extends FollowOwnerGoal {
//
//		public KayentasuchusFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
//			super(tameable, speed, minDist, maxDist, teleportToLeaves);
//		}
//
//		public boolean canUse() {
//			return super.canUse() && !Kayentasuchus.this.isTameSitting() && !Kayentasuchus.this.isTameWandering();
//		}
//
//	}
//	
//	public class KayentasuchusBreakWebsGoal extends MoveToBlockGoal {
//	      protected int ticksWaited;
//
//	      public KayentasuchusBreakWebsGoal(double p_28675_, int p_28676_, int p_28677_) {
//	         super(Kayentasuchus.this, p_28675_, p_28676_, p_28677_);
//	      }
//
//	      public double acceptedDistance() {
//	         return 2.0D;
//	      }
//
//	      public boolean shouldRecalculatePath() {
//	         return this.tryTicks % 100 == 0;
//	      }
//
//	      protected boolean isValidTarget(LevelReader p_28680_, BlockPos p_28681_) {
//	         BlockState blockstate = p_28680_.getBlockState(p_28681_);
//	         return blockstate.is(Blocks.COBWEB);
//	      }
//
//	      public void tick() {
//	         if (this.isReachedTarget()) {
//	            if (this.ticksWaited >= 40) {
//	               this.onReachedTarget();
//	            } else {
//	               ++this.ticksWaited;
//	            }
//	         }
//	         super.tick();
//	      }
//
//	      protected void onReachedTarget() {
//	         if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Kayentasuchus.this.level(), Kayentasuchus.this)) {
//	            BlockState blockstate = Kayentasuchus.this.level().getBlockState(this.blockPos);
//	               this.breakCobweb(blockstate);
//
//	         }
//	      }
//
//	      private void breakCobweb(BlockState p_148929_) {
//	         Block.popResource(Kayentasuchus.this.level(), this.blockPos, new ItemStack(Items.SWEET_BERRIES, 1 + Kayentasuchus.this.getRandom().nextInt(3)));
//	         if (Kayentasuchus.this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
//	        	 Kayentasuchus.this.level().setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
//	         }
//	      }
//
//	      public boolean canUse() {
//	         return !Kayentasuchus.this.isSleeping() && !Kayentasuchus.this.isTameSitting() && super.canUse();
//	      }
//
//	      public void start() {
//	         this.ticksWaited = 0;
//	         super.start();
//	      }
//	   }

}
