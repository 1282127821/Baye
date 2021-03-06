package com.dl.baye.util;

import java.util.ArrayList;

import com.dl.baye.BattleView;


import android.graphics.Bitmap;
import android.graphics.Canvas;

public class General  extends Sprite{
	private Person person;
	//0：我方,1：敌方
	private int team;
	public void setAction(int action) {
		this.action = action;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setAttack(boolean isAttack) {
		this.isAttack = isAttack;
	}
	//0：未行动;1：已行动
	private int action;
	//0: 向右;1：向左
	private int direction;
	
	public int getAttackRange(){
		return person.getAttackRange();
	}
	
	public Person getPerson() {
		return person;
	}
	public int getTeam() {
		return team;
	}
	public int getAction() {
		return action;
	}
	public int getDirection() {
		return direction;
	}
	public int getMove() {
		return person.getMove();
	}
	public boolean isAttack() {
		return isAttack;
	}
	private boolean isAttack = false;
	public General(Person person,int team, int col, int row) {
		super(col, row);
		this.person = person;
		this.team = team;
		this.action = 0;
		this.direction = team;
		this.setAnimationSegment(team);
	}

	public boolean isEqual(General g){
		return g.getPerson().getId() == this.getPerson().getId();
	}
	
	public void drawSelf(Canvas canvas, Bitmap[] bmps, Bitmap acitonEnd,int screenX, int screenY) {		
		super.drawSelf(canvas, bmps, screenX, screenY);
		if(this.action == 1){
			canvas.drawBitmap(acitonEnd,screenX, screenY,null);
		}
	}
	
	public void moveTo(int col,int row){
		setX(col);
		setY(row);
	}
}
