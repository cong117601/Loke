package com.yunhe.javabean;

import java.io.Serializable;
import java.math.BigDecimal;

public class cTestStudent implements Serializable {
 private BigDecimal ID;
 private String NAME;
 private BigDecimal AGE;
 private String SEX;
public cTestStudent() {
	super();
}
public cTestStudent(BigDecimal iD, String nAME, BigDecimal aGE, String sEX) {
	super();
	ID = iD;
	NAME = nAME;
	AGE = aGE;
	SEX = sEX;
}
public BigDecimal getID() {
	return ID;
}
public void setID(BigDecimal iD) {
	ID = iD;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public BigDecimal getAGE() {
	return AGE;
}
public void setAGE(BigDecimal aGE) {
	AGE = aGE;
}
public String getSEX() {
	return SEX;
}
public void setSEX(String sEX) {
	SEX = sEX;
}
@Override
public String toString() {
	return "cTestStudent [ID=" + ID + ", NAME=" + NAME + ", AGE=" + AGE + ", SEX=" + SEX + "]";
}


}
