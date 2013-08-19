//auto-generated model template
//template generated by MEIM
//template v 1.0
//author Shadowmage45 (shadowage_catapults@hotmail.com)
 
package shadowmage.ancient_warfare.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import shadowmage.ancient_warfare.common.utils.Trig;
 
 
public class ModelBoatBallista extends ModelVehicleBase
{
 
ModelRenderer bottomP1;
ModelRenderer bow;
ModelRenderer leftHull1;
ModelRenderer leftHull2;
ModelRenderer bow2;
ModelRenderer leftHull3;
ModelRenderer leftHull4;
ModelRenderer leftHull5;
ModelRenderer leftHull6;
ModelRenderer bow4P1;
ModelRenderer bowTop;
ModelRenderer bow3;
ModelRenderer bow3P1;
ModelRenderer leftRight1;
ModelRenderer rightHull2;
ModelRenderer rightHull3;
ModelRenderer rightHull4;
ModelRenderer rightHull5;
ModelRenderer rightHull6;
ModelRenderer stern;
ModelRenderer paddleLeft;
ModelRenderer paddleRight;
ModelRenderer padleAxle;
ModelRenderer sokeL1;
ModelRenderer paddle2;
ModelRenderer paddle6;
ModelRenderer sokeR1;
ModelRenderer sokeL2;
ModelRenderer paddle1;
ModelRenderer paddle5;
ModelRenderer sokeR2;
ModelRenderer sokeR3;
ModelRenderer sokeR4;
ModelRenderer sokeL3;
ModelRenderer paddle4;
ModelRenderer paddle7;
ModelRenderer sokeL4;
ModelRenderer paddle3;
ModelRenderer paddle8;
ModelRenderer paddleLeft2;
ModelRenderer paddleRight2;
ModelRenderer bow5P1;
ModelRenderer bow6P2;
ModelRenderer armMain;
ModelRenderer armFront;
ModelRenderer turretHorizontalBrace2;
ModelRenderer turretHorizontalBrace3;
ModelRenderer armMidBrace;
ModelRenderer armSlotLeft;
ModelRenderer armSlotRight;
ModelRenderer armleftVertical3;
ModelRenderer armLeftVertical2;
ModelRenderer armLeftVertical1;
ModelRenderer turretHorizontalBrace4;
ModelRenderer leftTensionerRope;
ModelRenderer leftTensioner;
ModelRenderer leftTensioner2;
ModelRenderer rightTensionerRope;
ModelRenderer rightTensioner;
ModelRenderer rightTensioner2;
ModelRenderer turretHorizontalBrace1;
ModelRenderer armRightVertical3;
ModelRenderer armRightVertical2;
ModelRenderer armRightVertical1;
ModelRenderer trigger1;
ModelRenderer trigger2;
ModelRenderer crankAxle;
ModelRenderer crankHandle1;
ModelRenderer crankHandle2;
ModelRenderer catch2;
ModelRenderer catch1;
ModelRenderer armRightMain;
ModelRenderer armRightMainInner;
ModelRenderer armRightMainInner3;
ModelRenderer armRightMainInner2;
ModelRenderer armRightInner;
ModelRenderer armRightOuter;
ModelRenderer stringRight;
ModelRenderer armLeftMain;
ModelRenderer armLeftMainInner;
ModelRenderer armLeftOuter;
ModelRenderer armLeftMainInner2;
ModelRenderer armLeftMainInner3;
ModelRenderer armLeftInner;
ModelRenderer stringLeft;
ModelRenderer ballistaPivot;
ModelRenderer bow5P2;
ModelRenderer bow4P2;
ModelRenderer bow6P1;
ModelRenderer bow3P2;
ModelRenderer bottomP2;
ModelRenderer bottomP3;
ModelRenderer bottomP4;
ModelRenderer chairBrace;
ModelRenderer chairBottom;
ModelRenderer chairBack;
ModelRenderer deckP1;
ModelRenderer deckP2;
ModelRenderer deckP3;
ModelRenderer deckP4;
ModelRenderer flagPole;
ModelRenderer flagCloth;
public ModelBoatBallista(){
  bottomP1 = new ModelRenderer(this,"bottomP1");
  bottomP1.setTextureOffset(0,31);
  bottomP1.setTextureSize(256,256);
  bottomP1.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(bottomP1,0.0f, 0.0f, 0.0f);
  bottomP1.addBox(-15.0f,-1.0f,-24.0f,15,1,24);
  bow = new ModelRenderer(this,"bow");
  bow.setTextureOffset(161,89);
  bow.setTextureSize(256,256);
  bow.setRotationPoint(0.0f, 0.0f, -24.0f);
  setPieceRotation(bow,-0.7853974f, 0.0f, 3.120892E-9f);
  bow.addBox(-15.5f,-1.0f,-16.0f,31,1,16);
  bottomP1.addChild(bow);
  leftHull1 = new ModelRenderer(this,"leftHull1");
  leftHull1.setTextureOffset(157,28);
  leftHull1.setTextureSize(256,256);
  leftHull1.setRotationPoint(15.0f, -1.0f, 0.0f);
  setPieceRotation(leftHull1,0.0f, 0.0f, 0.0f);
  leftHull1.addBox(0.0f,-12.0f,-24.0f,1,12,48);
  bottomP1.addChild(leftHull1);
  leftHull2 = new ModelRenderer(this,"leftHull2");
  leftHull2.setTextureOffset(93,86);
  leftHull2.setTextureSize(256,256);
  leftHull2.setRotationPoint(15.0f, -12.0f, -35.0f);
  setPieceRotation(leftHull2,0.0f, 0.0f, 0.0f);
  leftHull2.addBox(0.0f,-1.0f,0.0f,1,3,11);
  bottomP1.addChild(leftHull2);
  bow2 = new ModelRenderer(this,"bow2");
  bow2.setTextureOffset(154,5);
  bow2.setTextureSize(256,256);
  bow2.setRotationPoint(0.0f, 0.0f, -25.0f);
  setPieceRotation(bow2,-0.7853974f, 0.0f, 3.120892E-9f);
  bow2.addBox(14.5f,-2.0f,-17.0f,2,2,17);
  bottomP1.addChild(bow2);
  leftHull3 = new ModelRenderer(this,"leftHull3");
  leftHull3.setTextureOffset(132,76);
  leftHull3.setTextureSize(256,256);
  leftHull3.setRotationPoint(15.0f, -9.0f, -33.0f);
  setPieceRotation(leftHull3,0.0f, 0.0f, 0.0f);
  leftHull3.addBox(0.0f,-1.0f,0.0f,1,2,9);
  bottomP1.addChild(leftHull3);
  leftHull4 = new ModelRenderer(this,"leftHull4");
  leftHull4.setTextureOffset(115,76);
  leftHull4.setTextureSize(256,256);
  leftHull4.setRotationPoint(15.0f, -7.0f, -31.0f);
  setPieceRotation(leftHull4,0.0f, 0.0f, 0.0f);
  leftHull4.addBox(0.0f,-1.0f,0.0f,1,2,7);
  bottomP1.addChild(leftHull4);
  leftHull5 = new ModelRenderer(this,"leftHull5");
  leftHull5.setTextureOffset(102,76);
  leftHull5.setTextureSize(256,256);
  leftHull5.setRotationPoint(15.0f, -5.0f, -29.0f);
  setPieceRotation(leftHull5,0.0f, 0.0f, 0.0f);
  leftHull5.addBox(0.0f,-1.0f,0.0f,1,2,5);
  bottomP1.addChild(leftHull5);
  leftHull6 = new ModelRenderer(this,"leftHull6");
  leftHull6.setTextureOffset(93,76);
  leftHull6.setTextureSize(256,256);
  leftHull6.setRotationPoint(15.0f, -3.0f, -27.0f);
  setPieceRotation(leftHull6,0.0f, 0.0f, 0.0f);
  leftHull6.addBox(0.0f,-1.0f,0.0f,1,2,3);
  bottomP1.addChild(leftHull6);
  bow4P1 = new ModelRenderer(this,"bow4P1");
  bow4P1.setTextureOffset(91,33);
  bow4P1.setTextureSize(256,256);
  bow4P1.setRotationPoint(0.001f, 0.0f, -9.0f);
  setPieceRotation(bow4P1,0.0f, 0.0f, 3.120892E-9f);
  bow4P1.addBox(14.5f,-2.0f,-16.0f,2,2,25);
  bottomP1.addChild(bow4P1);
  bowTop = new ModelRenderer(this,"bowTop");
  bowTop.setTextureOffset(154,0);
  bowTop.setTextureSize(256,256);
  bowTop.setRotationPoint(0.0f, -0.5f, -24.0f);
  setPieceRotation(bowTop,-0.7853974f, 0.0f, 3.120892E-9f);
  bowTop.addBox(-15.5f,-1.0f,-17.0f,31,2,2);
  bottomP1.addChild(bowTop);
  bow3 = new ModelRenderer(this,"bow3");
  bow3.setTextureOffset(154,5);
  bow3.setTextureSize(256,256);
  bow3.setRotationPoint(1.0f, 0.0f, -25.0f);
  setPieceRotation(bow3,-0.7853973f, 0.0f, 3.120892E-9f);
  bow3.addBox(-17.5f,-2.0f,-17.0f,2,2,17);
  bottomP1.addChild(bow3);
  bow3P1 = new ModelRenderer(this,"bow3P1");
  bow3P1.setTextureOffset(91,33);
  bow3P1.setTextureSize(256,256);
  bow3P1.setRotationPoint(-32.001f, 0.0f, -9.0f);
  setPieceRotation(bow3P1,0.0f, 0.0f, 3.120892E-9f);
  bow3P1.addBox(15.5f,-2.0f,-16.0f,2,2,25);
  bottomP1.addChild(bow3P1);
  leftRight1 = new ModelRenderer(this,"leftRight1");
  leftRight1.setTextureOffset(157,28);
  leftRight1.setTextureSize(256,256);
  leftRight1.setRotationPoint(-16.0f, -1.0f, 0.0f);
  setPieceRotation(leftRight1,0.0f, 0.0f, 0.0f);
  leftRight1.addBox(0.0f,-12.0f,-24.0f,1,12,48);
  bottomP1.addChild(leftRight1);
  rightHull2 = new ModelRenderer(this,"rightHull2");
  rightHull2.setTextureOffset(93,86);
  rightHull2.setTextureSize(256,256);
  rightHull2.setRotationPoint(-16.0f, -12.0f, -35.0f);
  setPieceRotation(rightHull2,0.0f, 0.0f, 0.0f);
  rightHull2.addBox(0.0f,-1.0f,0.0f,1,3,11);
  bottomP1.addChild(rightHull2);
  rightHull3 = new ModelRenderer(this,"rightHull3");
  rightHull3.setTextureOffset(132,76);
  rightHull3.setTextureSize(256,256);
  rightHull3.setRotationPoint(-16.0f, -9.0f, -33.0f);
  setPieceRotation(rightHull3,0.0f, 0.0f, 0.0f);
  rightHull3.addBox(0.0f,-1.0f,0.0f,1,2,9);
  bottomP1.addChild(rightHull3);
  rightHull4 = new ModelRenderer(this,"rightHull4");
  rightHull4.setTextureOffset(115,76);
  rightHull4.setTextureSize(256,256);
  rightHull4.setRotationPoint(-16.0f, -7.0f, -31.0f);
  setPieceRotation(rightHull4,0.0f, 0.0f, 0.0f);
  rightHull4.addBox(0.0f,-1.0f,0.0f,1,2,7);
  bottomP1.addChild(rightHull4);
  rightHull5 = new ModelRenderer(this,"rightHull5");
  rightHull5.setTextureOffset(102,76);
  rightHull5.setTextureSize(256,256);
  rightHull5.setRotationPoint(-16.0f, -5.0f, -29.0f);
  setPieceRotation(rightHull5,0.0f, 0.0f, 0.0f);
  rightHull5.addBox(0.0f,-1.0f,0.0f,1,2,5);
  bottomP1.addChild(rightHull5);
  rightHull6 = new ModelRenderer(this,"rightHull6");
  rightHull6.setTextureOffset(93,76);
  rightHull6.setTextureSize(256,256);
  rightHull6.setRotationPoint(-16.0f, -3.0f, -27.0f);
  setPieceRotation(rightHull6,0.0f, 0.0f, 0.0f);
  rightHull6.addBox(0.0f,-1.0f,0.0f,1,2,3);
  bottomP1.addChild(rightHull6);
  stern = new ModelRenderer(this,"stern");
  stern.setTextureOffset(93,61);
  stern.setTextureSize(256,256);
  stern.setRotationPoint(0.0f, 0.0f, 39.999f);
  setPieceRotation(stern,0.0f, 0.0f, 3.120892E-9f);
  stern.addBox(-16.0f,-13.0f,-16.0f,32,13,1);
  bottomP1.addChild(stern);
  paddleLeft = new ModelRenderer(this,"paddleLeft");
  paddleLeft.setTextureOffset(0,67);
  paddleLeft.setTextureSize(256,256);
  paddleLeft.setRotationPoint(9.0f, -10.0f, 25.0f);
  setPieceRotation(paddleLeft,0.0f, 0.0f, 0.0f);
  paddleLeft.addBox(0.0f,0.0f,0.0f,1,6,8);
  bottomP1.addChild(paddleLeft);
  paddleRight = new ModelRenderer(this,"paddleRight");
  paddleRight.setTextureOffset(0,67);
  paddleRight.setTextureSize(256,256);
  paddleRight.setRotationPoint(-9.0f, -10.0f, 25.0f);
  setPieceRotation(paddleRight,0.0f, 0.0f, 0.0f);
  paddleRight.addBox(0.0f,0.0f,0.0f,1,6,8);
  padleAxle = new ModelRenderer(this,"padleAxle");
  padleAxle.setTextureOffset(0,64);
  padleAxle.setTextureSize(256,256);
  padleAxle.setRotationPoint(-1.0f, 3.0f, 8.5f);
  setPieceRotation(padleAxle,5.1312466f, -2.4967136E-8f, 1.2483568E-8f);
  padleAxle.addBox(-0.0f,-0.5f,-0.5f,21,1,1);
  sokeL1 = new ModelRenderer(this,"sokeL1");
  sokeL1.setTextureOffset(0,98);
  sokeL1.setTextureSize(256,256);
  sokeL1.setRotationPoint(18.0f, 0.0f, 0.0f);
  setPieceRotation(sokeL1,0.0f, 0.0f, 0.0f);
  sokeL1.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  paddle2 = new ModelRenderer(this,"paddle2");
  paddle2.setTextureOffset(0,57);
  paddle2.setTextureSize(256,256);
  paddle2.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle2,0.0f, 0.0f, 0.0f);
  paddle2.addBox(-0.5f,-0.5f,1.5f,14,1,5);
  sokeL1.addChild(paddle2);
  paddle6 = new ModelRenderer(this,"paddle6");
  paddle6.setTextureOffset(0,57);
  paddle6.setTextureSize(256,256);
  paddle6.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle6,0.0f, 0.0f, 0.0f);
  paddle6.addBox(-0.5f,-0.5f,-7.5f,14,1,5);
  sokeL1.addChild(paddle6);
  padleAxle.addChild(sokeL1);
  sokeR1 = new ModelRenderer(this,"sokeR1");
  sokeR1.setTextureOffset(0,98);
  sokeR1.setTextureSize(256,256);
  sokeR1.setRotationPoint(3.0f, 0.0f, 0.0f);
  setPieceRotation(sokeR1,1.0402973E-9f, 0.0f, 0.0f);
  sokeR1.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  padleAxle.addChild(sokeR1);
  sokeL2 = new ModelRenderer(this,"sokeL2");
  sokeL2.setTextureOffset(0,98);
  sokeL2.setTextureSize(256,256);
  sokeL2.setRotationPoint(18.0f, 0.0f, 0.0f);
  setPieceRotation(sokeL2,1.5707964f, 0.0f, 0.0f);
  sokeL2.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  paddle1 = new ModelRenderer(this,"paddle1");
  paddle1.setTextureOffset(0,57);
  paddle1.setTextureSize(256,256);
  paddle1.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle1,0.0f, 0.0f, 0.0f);
  paddle1.addBox(-0.5f,-0.5f,1.5f,14,1,5);
  sokeL2.addChild(paddle1);
  paddle5 = new ModelRenderer(this,"paddle5");
  paddle5.setTextureOffset(0,57);
  paddle5.setTextureSize(256,256);
  paddle5.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle5,0.0f, 0.0f, 0.0f);
  paddle5.addBox(-0.5f,-0.5f,-7.5f,14,1,5);
  sokeL2.addChild(paddle5);
  padleAxle.addChild(sokeL2);
  sokeR2 = new ModelRenderer(this,"sokeR2");
  sokeR2.setTextureOffset(0,98);
  sokeR2.setTextureSize(256,256);
  sokeR2.setRotationPoint(3.0f, 0.0f, 0.0f);
  setPieceRotation(sokeR2,1.5707964f, 0.0f, 0.0f);
  sokeR2.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  padleAxle.addChild(sokeR2);
  sokeR3 = new ModelRenderer(this,"sokeR3");
  sokeR3.setTextureOffset(0,98);
  sokeR3.setTextureSize(256,256);
  sokeR3.setRotationPoint(3.0f, 0.0f, 0.0f);
  setPieceRotation(sokeR3,0.7853982f, 0.0f, 0.0f);
  sokeR3.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  padleAxle.addChild(sokeR3);
  sokeR4 = new ModelRenderer(this,"sokeR4");
  sokeR4.setTextureOffset(0,98);
  sokeR4.setTextureSize(256,256);
  sokeR4.setRotationPoint(3.0f, 0.0f, 0.0f);
  setPieceRotation(sokeR4,-0.7853982f, 0.0f, 0.0f);
  sokeR4.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  padleAxle.addChild(sokeR4);
  sokeL3 = new ModelRenderer(this,"sokeL3");
  sokeL3.setTextureOffset(0,98);
  sokeL3.setTextureSize(256,256);
  sokeL3.setRotationPoint(18.0f, 0.0f, 0.0f);
  setPieceRotation(sokeL3,0.7853982f, 0.0f, 0.0f);
  sokeL3.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  paddle4 = new ModelRenderer(this,"paddle4");
  paddle4.setTextureOffset(0,57);
  paddle4.setTextureSize(256,256);
  paddle4.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle4,0.0f, 0.0f, 0.0f);
  paddle4.addBox(-0.5f,-0.5f,1.5f,14,1,5);
  sokeL3.addChild(paddle4);
  paddle7 = new ModelRenderer(this,"paddle7");
  paddle7.setTextureOffset(0,57);
  paddle7.setTextureSize(256,256);
  paddle7.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle7,0.0f, 0.0f, 0.0f);
  paddle7.addBox(-0.5f,-0.5f,-7.5f,14,1,5);
  sokeL3.addChild(paddle7);
  padleAxle.addChild(sokeL3);
  sokeL4 = new ModelRenderer(this,"sokeL4");
  sokeL4.setTextureOffset(0,98);
  sokeL4.setTextureSize(256,256);
  sokeL4.setRotationPoint(18.0f, 0.0f, 0.0f);
  setPieceRotation(sokeL4,-0.7853982f, 0.0f, 0.0f);
  sokeL4.addBox(-0.5f,-0.5f,-7.5f,1,1,14);
  paddle3 = new ModelRenderer(this,"paddle3");
  paddle3.setTextureOffset(0,57);
  paddle3.setTextureSize(256,256);
  paddle3.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle3,0.0f, 0.0f, 0.0f);
  paddle3.addBox(-0.5f,-0.5f,1.5f,14,1,5);
  sokeL4.addChild(paddle3);
  paddle8 = new ModelRenderer(this,"paddle8");
  paddle8.setTextureOffset(0,57);
  paddle8.setTextureSize(256,256);
  paddle8.setRotationPoint(-14.0f, 0.0f, 0.0f);
  setPieceRotation(paddle8,0.0f, 0.0f, 0.0f);
  paddle8.addBox(-0.5f,-0.5f,-7.5f,14,1,5);
  sokeL4.addChild(paddle8);
  padleAxle.addChild(sokeL4);
  paddleRight.addChild(padleAxle);
  bottomP1.addChild(paddleRight);
  paddleLeft2 = new ModelRenderer(this,"paddleLeft2");
  paddleLeft2.setTextureOffset(54,57);
  paddleLeft2.setTextureSize(256,256);
  paddleLeft2.setRotationPoint(9.0f, -9.0f, 33.0f);
  setPieceRotation(paddleLeft2,0.0f, 0.0f, 0.0f);
  paddleLeft2.addBox(0.0f,0.0f,0.0f,1,4,2);
  bottomP1.addChild(paddleLeft2);
  paddleRight2 = new ModelRenderer(this,"paddleRight2");
  paddleRight2.setTextureOffset(54,57);
  paddleRight2.setTextureSize(256,256);
  paddleRight2.setRotationPoint(-9.0f, -9.0f, 33.0f);
  setPieceRotation(paddleRight2,0.0f, 0.0f, 0.0f);
  paddleRight2.addBox(0.0f,0.0f,0.0f,1,4,2);
  bottomP1.addChild(paddleRight2);
  bow5P1 = new ModelRenderer(this,"bow5P1");
  bow5P1.setTextureOffset(89,0);
  bow5P1.setTextureSize(256,256);
  bow5P1.setRotationPoint(0.001f, -11.125f, -19.25f);
  setPieceRotation(bow5P1,0.0f, 0.0f, 3.120892E-9f);
  bow5P1.addBox(14.5f,-2.0f,-16.0f,2,2,30);
  bottomP1.addChild(bow5P1);
  bow6P2 = new ModelRenderer(this,"bow6P2");
  bow6P2.setTextureOffset(89,0);
  bow6P2.setTextureSize(256,256);
  bow6P2.setRotationPoint(-31.001f, -11.125f, 10.75f);
  setPieceRotation(bow6P2,0.0f, 0.0f, 3.120892E-9f);
  bow6P2.addBox(14.5f,-2.0f,-16.0f,2,2,30);
  bottomP1.addChild(bow6P2);
  armMain = new ModelRenderer(this,"armMain");
  armMain.setTextureOffset(0,128);
  armMain.setTextureSize(256,256);
  armMain.setRotationPoint(0.0f, -18.0f, -23.0f);
  setPieceRotation(armMain,-6.585082E-7f, -2.3593943E-6f, 0.0f);
  armMain.addBox(-1.5f,-2.0f,-4.5f,3,2,28);
  armFront = new ModelRenderer(this,"armFront");
  armFront.setTextureOffset(63,128);
  armFront.setTextureSize(256,256);
  armFront.setRotationPoint(-1.5f, -2.0f, -11.5f);
  setPieceRotation(armFront,0.0f, 0.0f, 0.0f);
  armFront.addBox(0.0f,0.0f,0.0f,3,2,4);
  armMain.addChild(armFront);
  turretHorizontalBrace2 = new ModelRenderer(this,"turretHorizontalBrace2");
  turretHorizontalBrace2.setTextureOffset(63,135);
  turretHorizontalBrace2.setTextureSize(256,256);
  turretHorizontalBrace2.setRotationPoint(11.0f, -1.5f, -4.5f);
  setPieceRotation(turretHorizontalBrace2,0.0f, 0.5410521f, 0.0f);
  turretHorizontalBrace2.addBox(-13.0f,0.0f,-3.0f,13,1,3);
  armMain.addChild(turretHorizontalBrace2);
  turretHorizontalBrace3 = new ModelRenderer(this,"turretHorizontalBrace3");
  turretHorizontalBrace3.setTextureOffset(63,140);
  turretHorizontalBrace3.setTextureSize(256,256);
  turretHorizontalBrace3.setRotationPoint(-11.0f, -2.0f, -7.5f);
  setPieceRotation(turretHorizontalBrace3,0.0f, 0.0f, 0.0f);
  turretHorizontalBrace3.addBox(0.0f,0.0f,0.0f,22,2,3);
  armMain.addChild(turretHorizontalBrace3);
  armMidBrace = new ModelRenderer(this,"armMidBrace");
  armMidBrace.setTextureOffset(0,159);
  armMidBrace.setTextureSize(256,256);
  armMidBrace.setRotationPoint(-1.5f, -3.0f, -11.5f);
  setPieceRotation(armMidBrace,0.0f, 0.0f, 0.0f);
  armMidBrace.addBox(0.0f,0.0f,0.0f,3,1,35);
  armMain.addChild(armMidBrace);
  armSlotLeft = new ModelRenderer(this,"armSlotLeft");
  armSlotLeft.setTextureOffset(77,159);
  armSlotLeft.setTextureSize(256,256);
  armSlotLeft.setRotationPoint(0.5f, -4.0f, -11.5f);
  setPieceRotation(armSlotLeft,0.0f, 0.0f, 0.0f);
  armSlotLeft.addBox(0.0f,0.0f,0.0f,1,1,35);
  armMain.addChild(armSlotLeft);
  armSlotRight = new ModelRenderer(this,"armSlotRight");
  armSlotRight.setTextureOffset(77,159);
  armSlotRight.setTextureSize(256,256);
  armSlotRight.setRotationPoint(-1.5f, -4.0f, -11.5f);
  setPieceRotation(armSlotRight,0.0f, 0.0f, 0.0f);
  armSlotRight.addBox(0.0f,0.0f,0.0f,1,1,35);
  armMain.addChild(armSlotRight);
  armleftVertical3 = new ModelRenderer(this,"armleftVertical3");
  armleftVertical3.setTextureOffset(78,128);
  armleftVertical3.setTextureSize(256,256);
  armleftVertical3.setRotationPoint(10.0f, -3.0f, -6.0f);
  setPieceRotation(armleftVertical3,0.0f, 0.0f, 0.0f);
  armleftVertical3.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armleftVertical3);
  armLeftVertical2 = new ModelRenderer(this,"armLeftVertical2");
  armLeftVertical2.setTextureOffset(78,128);
  armLeftVertical2.setTextureSize(256,256);
  armLeftVertical2.setRotationPoint(10.0f, -7.0f, -6.0f);
  setPieceRotation(armLeftVertical2,0.0f, 0.0f, 0.0f);
  armLeftVertical2.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armLeftVertical2);
  armLeftVertical1 = new ModelRenderer(this,"armLeftVertical1");
  armLeftVertical1.setTextureOffset(83,128);
  armLeftVertical1.setTextureSize(256,256);
  armLeftVertical1.setRotationPoint(10.0f, -7.0f, -7.0f);
  setPieceRotation(armLeftVertical1,0.0f, 0.0f, 0.0f);
  armLeftVertical1.addBox(0.0f,0.0f,0.0f,1,5,1);
  armMain.addChild(armLeftVertical1);
  turretHorizontalBrace4 = new ModelRenderer(this,"turretHorizontalBrace4");
  turretHorizontalBrace4.setTextureOffset(63,140);
  turretHorizontalBrace4.setTextureSize(256,256);
  turretHorizontalBrace4.setRotationPoint(-11.0f, -9.0f, -7.5f);
  setPieceRotation(turretHorizontalBrace4,0.0f, 0.0f, 0.0f);
  turretHorizontalBrace4.addBox(0.0f,0.0f,0.0f,22,2,3);
  armMain.addChild(turretHorizontalBrace4);
  leftTensionerRope = new ModelRenderer(this,"leftTensionerRope");
  leftTensionerRope.setTextureOffset(114,128);
  leftTensionerRope.setTextureSize(256,256);
  leftTensionerRope.setRotationPoint(5.5f, -7.0f, -6.0f);
  setPieceRotation(leftTensionerRope,0.0f, 0.0f, 0.0f);
  leftTensionerRope.addBox(-0.5f,-3.0f,-0.5f,1,11,1);
  leftTensioner = new ModelRenderer(this,"leftTensioner");
  leftTensioner.setTextureOffset(88,128);
  leftTensioner.setTextureSize(256,256);
  leftTensioner.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(leftTensioner,0.0f, 0.0f, 0.0f);
  leftTensioner.addBox(-1.0f,-0.5f,-0.5f,2,1,1);
  leftTensionerRope.addChild(leftTensioner);
  leftTensioner2 = new ModelRenderer(this,"leftTensioner2");
  leftTensioner2.setTextureOffset(88,131);
  leftTensioner2.setTextureSize(256,256);
  leftTensioner2.setRotationPoint(0.0f, -3.0f, -0.0f);
  setPieceRotation(leftTensioner2,0.0f, 0.0f, 0.0f);
  leftTensioner2.addBox(-0.5f,-0.5f,-1.0f,1,1,2);
  leftTensionerRope.addChild(leftTensioner2);
  armMain.addChild(leftTensionerRope);
  rightTensionerRope = new ModelRenderer(this,"rightTensionerRope");
  rightTensionerRope.setTextureOffset(114,128);
  rightTensionerRope.setTextureSize(256,256);
  rightTensionerRope.setRotationPoint(-5.5f, -7.0f, -6.0f);
  setPieceRotation(rightTensionerRope,0.0f, 0.0f, 0.0f);
  rightTensionerRope.addBox(-0.5f,-3.0f,-0.5f,1,11,1);
  rightTensioner = new ModelRenderer(this,"rightTensioner");
  rightTensioner.setTextureOffset(88,128);
  rightTensioner.setTextureSize(256,256);
  rightTensioner.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(rightTensioner,0.0f, 0.0f, 0.0f);
  rightTensioner.addBox(-1.0f,-0.5f,-0.5f,2,1,1);
  rightTensionerRope.addChild(rightTensioner);
  rightTensioner2 = new ModelRenderer(this,"rightTensioner2");
  rightTensioner2.setTextureOffset(88,131);
  rightTensioner2.setTextureSize(256,256);
  rightTensioner2.setRotationPoint(0.0f, -3.0f, 0.0f);
  setPieceRotation(rightTensioner2,0.0f, 0.0f, 0.0f);
  rightTensioner2.addBox(-0.5f,-0.5f,-1.0f,1,1,2);
  rightTensionerRope.addChild(rightTensioner2);
  armMain.addChild(rightTensionerRope);
  turretHorizontalBrace1 = new ModelRenderer(this,"turretHorizontalBrace1");
  turretHorizontalBrace1.setTextureOffset(63,135);
  turretHorizontalBrace1.setTextureSize(256,256);
  turretHorizontalBrace1.setRotationPoint(-11.0f, -1.5f, -4.5f);
  setPieceRotation(turretHorizontalBrace1,0.0f, -0.5410521f, 0.0f);
  turretHorizontalBrace1.addBox(0.0f,0.0f,-3.0f,13,1,3);
  armMain.addChild(turretHorizontalBrace1);
  armRightVertical3 = new ModelRenderer(this,"armRightVertical3");
  armRightVertical3.setTextureOffset(78,128);
  armRightVertical3.setTextureSize(256,256);
  armRightVertical3.setRotationPoint(-11.0f, -3.0f, -6.0f);
  setPieceRotation(armRightVertical3,0.0f, 0.0f, 0.0f);
  armRightVertical3.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armRightVertical3);
  armRightVertical2 = new ModelRenderer(this,"armRightVertical2");
  armRightVertical2.setTextureOffset(78,128);
  armRightVertical2.setTextureSize(256,256);
  armRightVertical2.setRotationPoint(-11.0f, -7.0f, -6.0f);
  setPieceRotation(armRightVertical2,0.0f, 0.0f, 0.0f);
  armRightVertical2.addBox(0.0f,0.0f,0.0f,1,1,1);
  armMain.addChild(armRightVertical2);
  armRightVertical1 = new ModelRenderer(this,"armRightVertical1");
  armRightVertical1.setTextureOffset(83,128);
  armRightVertical1.setTextureSize(256,256);
  armRightVertical1.setRotationPoint(-11.0f, -7.0f, -7.0f);
  setPieceRotation(armRightVertical1,0.0f, 0.0f, 0.0f);
  armRightVertical1.addBox(0.0f,0.0f,0.0f,1,5,1);
  armMain.addChild(armRightVertical1);
  trigger1 = new ModelRenderer(this,"trigger1");
  trigger1.setTextureOffset(63,146);
  trigger1.setTextureSize(256,256);
  trigger1.setRotationPoint(-0.0f, -1.0f, 17.5f);
  setPieceRotation(trigger1,-1.256629f, 0.0f, 0.0f);
  trigger1.addBox(-0.5f,-1.0f,0.0f,1,1,5);
  trigger2 = new ModelRenderer(this,"trigger2");
  trigger2.setTextureOffset(76,146);
  trigger2.setTextureSize(256,256);
  trigger2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(trigger2,1.2217292f, 1.934953E-7f, 3.1625038E-7f);
  trigger2.addBox(-0.5f,-4.0f,0.0f,1,4,1);
  trigger1.addChild(trigger2);
  armMain.addChild(trigger1);
  crankAxle = new ModelRenderer(this,"crankAxle");
  crankAxle.setTextureOffset(63,153);
  crankAxle.setTextureSize(256,256);
  crankAxle.setRotationPoint(-2.0f, -2.0f, 21.0f);
  setPieceRotation(crankAxle,0.0f, 0.0f, 0.0f);
  crankAxle.addBox(0.0f,-0.5f,-0.5f,4,1,1);
  crankHandle1 = new ModelRenderer(this,"crankHandle1");
  crankHandle1.setTextureOffset(81,146);
  crankHandle1.setTextureSize(256,256);
  crankHandle1.setRotationPoint(-0.5f, 0.0f, 0.0f);
  setPieceRotation(crankHandle1,0.0f, 0.0f, 0.0f);
  crankHandle1.addBox(-0.5f,-2.5f,-0.5f,1,5,1);
  crankAxle.addChild(crankHandle1);
  crankHandle2 = new ModelRenderer(this,"crankHandle2");
  crankHandle2.setTextureOffset(86,146);
  crankHandle2.setTextureSize(256,256);
  crankHandle2.setRotationPoint(-0.5f, 0.0f, 0.0f);
  setPieceRotation(crankHandle2,0.0f, 0.0f, 0.0f);
  crankHandle2.addBox(-0.5f,-0.5f,-2.5f,1,1,5);
  crankAxle.addChild(crankHandle2);
  armMain.addChild(crankAxle);
  catch2 = new ModelRenderer(this,"catch2");
  catch2.setTextureOffset(99,146);
  catch2.setTextureSize(256,256);
  catch2.setRotationPoint(-1.0f, -6.0f, 20.5f);
  setPieceRotation(catch2,-0.8552113f, 0.0f, 0.0f);
  catch2.addBox(0.0f,0.0f,0.0f,2,1,4);
  armMain.addChild(catch2);
  catch1 = new ModelRenderer(this,"catch1");
  catch1.setTextureOffset(99,152);
  catch1.setTextureSize(256,256);
  catch1.setRotationPoint(-1.0f, -6.0f, 17.5f);
  setPieceRotation(catch1,0.0f, 0.0f, 0.0f);
  catch1.addBox(0.0f,0.0f,0.0f,2,1,3);
  armMain.addChild(catch1);
  armRightMain = new ModelRenderer(this,"armRightMain");
  armRightMain.setTextureOffset(0,215);
  armRightMain.setTextureSize(256,256);
  armRightMain.setRotationPoint(-5.5f, -5.0f, -6.0f);
  setPieceRotation(armRightMain,0.0f, 0.5235982f, 0.0f);
  armRightMain.addBox(-6.5f,-1.0f,-1.0f,8,3,1);
  armRightMainInner = new ModelRenderer(this,"armRightMainInner");
  armRightMainInner.setTextureOffset(0,203);
  armRightMainInner.setTextureSize(256,256);
  armRightMainInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner,0.0f, 0.0f, 0.0f);
  armRightMainInner.addBox(-2.5f,-1.0f,0.0f,4,3,1);
  armRightMain.addChild(armRightMainInner);
  armRightMainInner3 = new ModelRenderer(this,"armRightMainInner3");
  armRightMainInner3.setTextureOffset(0,196);
  armRightMainInner3.setTextureSize(256,256);
  armRightMainInner3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner3,0.0f, 0.0f, 0.0f);
  armRightMainInner3.addBox(-6.5f,0.0f,0.0f,4,1,1);
  armRightMain.addChild(armRightMainInner3);
  armRightMainInner2 = new ModelRenderer(this,"armRightMainInner2");
  armRightMainInner2.setTextureOffset(0,199);
  armRightMainInner2.setTextureSize(256,256);
  armRightMainInner2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightMainInner2,0.0f, 0.0f, 0.0f);
  armRightMainInner2.addBox(-6.5f,-0.5f,-0.5f,4,2,1);
  armRightMain.addChild(armRightMainInner2);
  armRightInner = new ModelRenderer(this,"armRightInner");
  armRightInner.setTextureOffset(0,208);
  armRightInner.setTextureSize(256,256);
  armRightInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightInner,0.0f, 0.0f, 0.0f);
  armRightInner.addBox(-13.25f,0.0f,-0.5f,7,1,1);
  armRightMain.addChild(armRightInner);
  armRightOuter = new ModelRenderer(this,"armRightOuter");
  armRightOuter.setTextureOffset(0,211);
  armRightOuter.setTextureSize(256,256);
  armRightOuter.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armRightOuter,0.0f, 0.0f, 0.0f);
  armRightOuter.addBox(-13.5f,-0.5f,-1.0f,7,2,1);
  armRightMain.addChild(armRightOuter);
  stringRight = new ModelRenderer(this,"stringRight");
  stringRight.setTextureOffset(0,220);
  stringRight.setTextureSize(256,256);
  stringRight.setRotationPoint(-13.0f, 0.5f, 0.0f);
  setPieceRotation(stringRight,0.0f, -0.5235985f, 0.0f);
  stringRight.addBox(0.0f,-0.5f,0.0f,17,1,1);
  armRightMain.addChild(stringRight);
  armMain.addChild(armRightMain);
  armLeftMain = new ModelRenderer(this,"armLeftMain");
  armLeftMain.setTextureOffset(0,215);
  armLeftMain.setTextureSize(256,256);
  armLeftMain.setRotationPoint(5.5f, -6.0f, -6.0f);
  setPieceRotation(armLeftMain,0.0f, -0.5235988f, 0.0f);
  armLeftMain.addBox(-1.5f,0.0f,-1.0f,8,3,1);
  armLeftMainInner = new ModelRenderer(this,"armLeftMainInner");
  armLeftMainInner.setTextureOffset(0,203);
  armLeftMainInner.setTextureSize(256,256);
  armLeftMainInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner,0.0f, 0.0f, 0.0f);
  armLeftMainInner.addBox(-1.5f,0.0f,0.0f,4,3,1);
  armLeftMain.addChild(armLeftMainInner);
  armLeftOuter = new ModelRenderer(this,"armLeftOuter");
  armLeftOuter.setTextureOffset(0,211);
  armLeftOuter.setTextureSize(256,256);
  armLeftOuter.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftOuter,0.0f, 0.0f, 0.0f);
  armLeftOuter.addBox(6.5f,0.5f,-1.0f,7,2,1);
  armLeftMain.addChild(armLeftOuter);
  armLeftMainInner2 = new ModelRenderer(this,"armLeftMainInner2");
  armLeftMainInner2.setTextureOffset(0,199);
  armLeftMainInner2.setTextureSize(256,256);
  armLeftMainInner2.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner2,0.0f, 0.0f, 0.0f);
  armLeftMainInner2.addBox(2.5f,0.5f,-0.5f,4,2,1);
  armLeftMain.addChild(armLeftMainInner2);
  armLeftMainInner3 = new ModelRenderer(this,"armLeftMainInner3");
  armLeftMainInner3.setTextureOffset(0,196);
  armLeftMainInner3.setTextureSize(256,256);
  armLeftMainInner3.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftMainInner3,0.0f, 0.0f, 0.0f);
  armLeftMainInner3.addBox(2.5f,1.0f,-0.0f,4,1,1);
  armLeftMain.addChild(armLeftMainInner3);
  armLeftInner = new ModelRenderer(this,"armLeftInner");
  armLeftInner.setTextureOffset(0,208);
  armLeftInner.setTextureSize(256,256);
  armLeftInner.setRotationPoint(0.0f, 0.0f, 0.0f);
  setPieceRotation(armLeftInner,0.0f, 0.0f, 0.0f);
  armLeftInner.addBox(6.25f,1.0f,-0.5f,7,1,1);
  armLeftMain.addChild(armLeftInner);
  stringLeft = new ModelRenderer(this,"stringLeft");
  stringLeft.setTextureOffset(0,220);
  stringLeft.setTextureSize(256,256);
  stringLeft.setRotationPoint(13.0f, 1.5f, 0.0f);
  setPieceRotation(stringLeft,0.0f, 0.5235985f, 0.0f);
  stringLeft.addBox(-17.0f,-0.5f,0.0f,17,1,1);
  armLeftMain.addChild(stringLeft);
  armMain.addChild(armLeftMain);
  bottomP1.addChild(armMain);
  ballistaPivot = new ModelRenderer(this,"ballistaPivot");
  ballistaPivot.setTextureOffset(61,57);
  ballistaPivot.setTextureSize(256,256);
  ballistaPivot.setRotationPoint(0.0f, -18.0f, -23.0f);
  setPieceRotation(ballistaPivot,0.0f, 0.0f, 0.0f);
  ballistaPivot.addBox(-1.0f,0.0f,-1.0f,2,8,2);
  bottomP1.addChild(ballistaPivot);
  bow5P2 = new ModelRenderer(this,"bow5P2");
  bow5P2.setTextureOffset(89,0);
  bow5P2.setTextureSize(256,256);
  bow5P2.setRotationPoint(0.001f, -11.125f, 10.75f);
  setPieceRotation(bow5P2,0.0f, 0.0f, 3.120892E-9f);
  bow5P2.addBox(14.5f,-2.0f,-16.0f,2,2,30);
  bottomP1.addChild(bow5P2);
  bow4P2 = new ModelRenderer(this,"bow4P2");
  bow4P2.setTextureOffset(91,33);
  bow4P2.setTextureSize(256,256);
  bow4P2.setRotationPoint(0.001f, 0.0f, 16.0f);
  setPieceRotation(bow4P2,0.0f, 0.0f, 3.120892E-9f);
  bow4P2.addBox(14.5f,-2.0f,-16.0f,2,2,25);
  bottomP1.addChild(bow4P2);
  bow6P1 = new ModelRenderer(this,"bow6P1");
  bow6P1.setTextureOffset(89,0);
  bow6P1.setTextureSize(256,256);
  bow6P1.setRotationPoint(-31.001f, -11.125f, -19.25f);
  setPieceRotation(bow6P1,0.0f, 0.0f, 3.120892E-9f);
  bow6P1.addBox(14.5f,-2.0f,-16.0f,2,2,30);
  bottomP1.addChild(bow6P1);
  bow3P2 = new ModelRenderer(this,"bow3P2");
  bow3P2.setTextureOffset(91,33);
  bow3P2.setTextureSize(256,256);
  bow3P2.setRotationPoint(-32.001f, 0.0f, 16.0f);
  setPieceRotation(bow3P2,0.0f, 0.0f, 3.120892E-9f);
  bow3P2.addBox(15.5f,-2.0f,-16.0f,2,2,25);
  bottomP1.addChild(bow3P2);
  bottomP2 = new ModelRenderer(this,"bottomP2");
  bottomP2.setTextureOffset(0,31);
  bottomP2.setTextureSize(256,256);
  bottomP2.setRotationPoint(0.0f, 0.0f, 24.0f);
  setPieceRotation(bottomP2,0.0f, 0.0f, 0.0f);
  bottomP2.addBox(-15.0f,-1.0f,-24.0f,15,1,24);
  bottomP1.addChild(bottomP2);
  bottomP3 = new ModelRenderer(this,"bottomP3");
  bottomP3.setTextureOffset(0,31);
  bottomP3.setTextureSize(256,256);
  bottomP3.setRotationPoint(15.0f, 0.0f, 24.0f);
  setPieceRotation(bottomP3,0.0f, 0.0f, 0.0f);
  bottomP3.addBox(-15.0f,-1.0f,-24.0f,15,1,24);
  bottomP1.addChild(bottomP3);
  bottomP4 = new ModelRenderer(this,"bottomP4");
  bottomP4.setTextureOffset(0,31);
  bottomP4.setTextureSize(256,256);
  bottomP4.setRotationPoint(15.0f, 0.0f, 0.0f);
  setPieceRotation(bottomP4,0.0f, 0.0f, 0.0f);
  bottomP4.addBox(-15.0f,-1.0f,-24.0f,15,1,24);
  bottomP1.addChild(bottomP4);
  chairBrace = new ModelRenderer(this,"chairBrace");
  chairBrace.setTextureOffset(70,59);
  chairBrace.setTextureSize(256,256);
  chairBrace.setRotationPoint(-1.5f, -11.0f, 18.0f);
  setPieceRotation(chairBrace,0.0f, 0.0f, 0.0f);
  chairBrace.addBox(0.0f,0.0f,-8.0f,3,1,7);
  chairBottom = new ModelRenderer(this,"chairBottom");
  chairBottom.setTextureOffset(54,68);
  chairBottom.setTextureSize(256,256);
  chairBottom.setRotationPoint(-3.5f, -1.5f, -1.0f);
  setPieceRotation(chairBottom,0.1570796f, 0.0f, 0.0f);
  chairBottom.addBox(0.0f,0.0f,-9.0f,10,1,9);
  chairBrace.addChild(chairBottom);
  chairBack = new ModelRenderer(this,"chairBack");
  chairBack.setTextureOffset(49,79);
  chairBack.setTextureSize(256,256);
  chairBack.setRotationPoint(-3.5f, -1.0f, -1.0f);
  setPieceRotation(chairBack,-0.1745329f, 0.0f, 0.0f);
  chairBack.addBox(0.0f,-10.0f,0.0f,10,10,1);
  chairBrace.addChild(chairBack);
  bottomP1.addChild(chairBrace);
  deckP1 = new ModelRenderer(this,"deckP1");
  deckP1.setTextureOffset(0,0);
  deckP1.setTextureSize(256,256);
  deckP1.setRotationPoint(0.0f, -9.25f, -9.1f);
  setPieceRotation(deckP1,0.0f, 0.0f, 0.0f);
  deckP1.addBox(-15.0f,-1.0f,-24.0f,15,1,29);
  deckP2 = new ModelRenderer(this,"deckP2");
  deckP2.setTextureOffset(0,0);
  deckP2.setTextureSize(256,256);
  deckP2.setRotationPoint(0.0f, -9.25f, 19.9f);
  setPieceRotation(deckP2,0.0f, 0.0f, 0.0f);
  deckP2.addBox(-15.0f,-1.0f,-24.0f,15,1,29);
  deckP3 = new ModelRenderer(this,"deckP3");
  deckP3.setTextureOffset(0,0);
  deckP3.setTextureSize(256,256);
  deckP3.setRotationPoint(15.0f, -9.25f, 19.9f);
  setPieceRotation(deckP3,0.0f, 0.0f, 0.0f);
  deckP3.addBox(-15.0f,-1.0f,-24.0f,15,1,29);
  deckP4 = new ModelRenderer(this,"deckP4");
  deckP4.setTextureOffset(0,0);
  deckP4.setTextureSize(256,256);
  deckP4.setRotationPoint(15.0f, -9.25f, -9.1f);
  setPieceRotation(deckP4,0.0f, 0.0f, 0.0f);
  deckP4.addBox(-15.0f,-1.0f,-24.0f,15,1,29);
  flagPole = new ModelRenderer(this,"flagPole");
  flagPole.setTextureOffset(19,78);
  flagPole.setTextureSize(256,256);
  flagPole.setRotationPoint(-14.0f, -29.0f, 24.0f);
  setPieceRotation(flagPole,0.0f, 0.0f, 0.0f);
  flagPole.addBox(0.0f,0.0f,0.0f,1,16,1);
  flagCloth = new ModelRenderer(this,"flagCloth");
  flagCloth.setTextureOffset(24,78);
  flagCloth.setTextureSize(256,256);
  flagCloth.setRotationPoint(-14.0f, -29.0f, 25.0f);
  setPieceRotation(flagCloth,0.0f, 0.0f, 0.0f);
  flagCloth.addBox(0.0f,0.0f,0.0f,1,8,11);
  }
 
@Override
public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
  {
  super.render(entity, f1, f2, f3, f4, f5, f6);
  setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
  armMain.render(f6);
  flagPole.render(0.0625f);
  bottomP1.render(f6);
  deckP1.render(f6);
  deckP2.render(f6);
  deckP3.render(f6);
  deckP4.render(f6);
  flagPole.render(f6);
  }

public void setPieceRotation(ModelRenderer model, float x, float y, float z)
  {
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
  }

public void setWheelRotations(float fl, float fr, float rl, float rr)
  {
  this.padleAxle.rotateAngleX = Trig.toRadians(fr);
  }

public void setTurretRotation(float yaw, float pitch)
  {
  this.armMain.rotateAngleY = Trig.toRadians(yaw);
  this.armMain.rotateAngleX = Trig.toRadians(pitch);
  }

public void setCrankRotations(float angle)
  {
  this.crankAxle.rotateAngleX = Trig.toRadians(angle);
  }

public void setTriggerAngle(float angle)
  {
  this.trigger1.rotateAngleX = Trig.toRadians(angle);
  }

public void setBowAndStringRotation(float bow, float string)
  {
  this.armLeftMain.rotateAngleY = Trig.toRadians(-bow);
  this.armRightMain.rotateAngleY = Trig.toRadians(bow);
  this.stringLeft.rotateAngleY = Trig.toRadians(-string);
  this.stringRight.rotateAngleY = Trig.toRadians(string);
  }

@Override
public void renderFlag()
  {
  flagCloth.render(0.0625f);  
  }
}
