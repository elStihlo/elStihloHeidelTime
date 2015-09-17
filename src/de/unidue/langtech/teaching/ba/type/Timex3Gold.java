

/* First created by JCasGen Wed Sep 16 16:34:35 CEST 2015 */
package de.unidue.langtech.teaching.ba.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Sep 16 16:34:35 CEST 2015
 * XML source: F:/Uni/BachelorArbeit/heideltime-kit-1.9/heideltime-kit/desc/type/Timex3Gold.xml
 * @generated */
public class Timex3Gold extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Timex3Gold.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Timex3Gold() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Timex3Gold(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Timex3Gold(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Timex3Gold(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: tID

  /** getter for tID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTID() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_tID == null)
      jcasType.jcas.throwFeatMissing("tID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_tID);}
    
  /** setter for tID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTID(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_tID == null)
      jcasType.jcas.throwFeatMissing("tID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_tID, v);}    
   
    
  //*--------------*
  //* Feature: Timex3type

  /** getter for Timex3type - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTimex3type() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_Timex3type == null)
      jcasType.jcas.throwFeatMissing("Timex3type", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_Timex3type);}
    
  /** setter for Timex3type - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTimex3type(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_Timex3type == null)
      jcasType.jcas.throwFeatMissing("Timex3type", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_Timex3type, v);}    
   
    
  //*--------------*
  //* Feature: mod

  /** getter for mod - gets 
   * @generated
   * @return value of the feature 
   */
  public String getMod() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_mod == null)
      jcasType.jcas.throwFeatMissing("mod", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_mod);}
    
  /** setter for mod - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setMod(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_mod == null)
      jcasType.jcas.throwFeatMissing("mod", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_mod, v);}    
   
    
  //*--------------*
  //* Feature: temporalFunction

  /** getter for temporalFunction - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTemporalFunction() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_temporalFunction == null)
      jcasType.jcas.throwFeatMissing("temporalFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_temporalFunction);}
    
  /** setter for temporalFunction - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTemporalFunction(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_temporalFunction == null)
      jcasType.jcas.throwFeatMissing("temporalFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_temporalFunction, v);}    
   
    
  //*--------------*
  //* Feature: anchorTimeID

  /** getter for anchorTimeID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getAnchorTimeID() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_anchorTimeID == null)
      jcasType.jcas.throwFeatMissing("anchorTimeID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_anchorTimeID);}
    
  /** setter for anchorTimeID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnchorTimeID(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_anchorTimeID == null)
      jcasType.jcas.throwFeatMissing("anchorTimeID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_anchorTimeID, v);}    
   
    
  //*--------------*
  //* Feature: valueFromFunction

  /** getter for valueFromFunction - gets 
   * @generated
   * @return value of the feature 
   */
  public String getValueFromFunction() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_valueFromFunction == null)
      jcasType.jcas.throwFeatMissing("valueFromFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_valueFromFunction);}
    
  /** setter for valueFromFunction - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setValueFromFunction(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_valueFromFunction == null)
      jcasType.jcas.throwFeatMissing("valueFromFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_valueFromFunction, v);}    
   
    
  //*--------------*
  //* Feature: functionInDocument

  /** getter for functionInDocument - gets 
   * @generated
   * @return value of the feature 
   */
  public String getFunctionInDocument() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_functionInDocument == null)
      jcasType.jcas.throwFeatMissing("functionInDocument", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_functionInDocument);}
    
  /** setter for functionInDocument - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFunctionInDocument(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_functionInDocument == null)
      jcasType.jcas.throwFeatMissing("functionInDocument", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_functionInDocument, v);}    
   
    
  //*--------------*
  //* Feature: beginPoint

  /** getter for beginPoint - gets 
   * @generated
   * @return value of the feature 
   */
  public String getBeginPoint() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_beginPoint == null)
      jcasType.jcas.throwFeatMissing("beginPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_beginPoint);}
    
  /** setter for beginPoint - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBeginPoint(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_beginPoint == null)
      jcasType.jcas.throwFeatMissing("beginPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_beginPoint, v);}    
   
    
  //*--------------*
  //* Feature: endPoint

  /** getter for endPoint - gets 
   * @generated
   * @return value of the feature 
   */
  public String getEndPoint() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_endPoint == null)
      jcasType.jcas.throwFeatMissing("endPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_endPoint);}
    
  /** setter for endPoint - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEndPoint(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_endPoint == null)
      jcasType.jcas.throwFeatMissing("endPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_endPoint, v);}    
   
    
  //*--------------*
  //* Feature: quant

  /** getter for quant - gets 
   * @generated
   * @return value of the feature 
   */
  public String getQuant() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_quant == null)
      jcasType.jcas.throwFeatMissing("quant", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_quant);}
    
  /** setter for quant - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuant(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_quant == null)
      jcasType.jcas.throwFeatMissing("quant", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_quant, v);}    
   
    
  //*--------------*
  //* Feature: freq

  /** getter for freq - gets 
   * @generated
   * @return value of the feature 
   */
  public String getFreq() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_freq == null)
      jcasType.jcas.throwFeatMissing("freq", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_freq);}
    
  /** setter for freq - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFreq(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_freq == null)
      jcasType.jcas.throwFeatMissing("freq", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_freq, v);}    
   
    
  //*--------------*
  //* Feature: value

  /** getter for value - gets 
   * @generated
   * @return value of the feature 
   */
  public String getValue() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setValue(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_value, v);}    
   
    
  //*--------------*
  //* Feature: Timex3Text

  /** getter for Timex3Text - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTimex3Text() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_Timex3Text == null)
      jcasType.jcas.throwFeatMissing("Timex3Text", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_Timex3Text);}
    
  /** setter for Timex3Text - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTimex3Text(String v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_Timex3Text == null)
      jcasType.jcas.throwFeatMissing("Timex3Text", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setStringValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_Timex3Text, v);}    
   
    
  //*--------------*
  //* Feature: checkMirror

  /** getter for checkMirror - gets default value is 0. If a match is found it should be set to 1
   * @generated
   * @return value of the feature 
   */
  public int getCheckMirror() {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_checkMirror == null)
      jcasType.jcas.throwFeatMissing("checkMirror", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_checkMirror);}
    
  /** setter for checkMirror - sets default value is 0. If a match is found it should be set to 1 
   * @generated
   * @param v value to set into the feature 
   */
  public void setCheckMirror(int v) {
    if (Timex3Gold_Type.featOkTst && ((Timex3Gold_Type)jcasType).casFeat_checkMirror == null)
      jcasType.jcas.throwFeatMissing("checkMirror", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    jcasType.ll_cas.ll_setIntValue(addr, ((Timex3Gold_Type)jcasType).casFeatCode_checkMirror, v);}    
  }

    