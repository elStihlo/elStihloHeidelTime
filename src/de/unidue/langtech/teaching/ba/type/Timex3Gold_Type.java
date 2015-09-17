
/* First created by JCasGen Wed Sep 16 16:34:35 CEST 2015 */
package de.unidue.langtech.teaching.ba.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Sep 16 16:34:35 CEST 2015
 * @generated */
public class Timex3Gold_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Timex3Gold_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Timex3Gold_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Timex3Gold(addr, Timex3Gold_Type.this);
  			   Timex3Gold_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Timex3Gold(addr, Timex3Gold_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Timex3Gold.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.ba.type.Timex3Gold");
 
  /** @generated */
  final Feature casFeat_tID;
  /** @generated */
  final int     casFeatCode_tID;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTID(int addr) {
        if (featOkTst && casFeat_tID == null)
      jcas.throwFeatMissing("tID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tID);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTID(int addr, String v) {
        if (featOkTst && casFeat_tID == null)
      jcas.throwFeatMissing("tID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_tID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Timex3type;
  /** @generated */
  final int     casFeatCode_Timex3type;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTimex3type(int addr) {
        if (featOkTst && casFeat_Timex3type == null)
      jcas.throwFeatMissing("Timex3type", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Timex3type);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTimex3type(int addr, String v) {
        if (featOkTst && casFeat_Timex3type == null)
      jcas.throwFeatMissing("Timex3type", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_Timex3type, v);}
    
  
 
  /** @generated */
  final Feature casFeat_mod;
  /** @generated */
  final int     casFeatCode_mod;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getMod(int addr) {
        if (featOkTst && casFeat_mod == null)
      jcas.throwFeatMissing("mod", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mod);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMod(int addr, String v) {
        if (featOkTst && casFeat_mod == null)
      jcas.throwFeatMissing("mod", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_mod, v);}
    
  
 
  /** @generated */
  final Feature casFeat_temporalFunction;
  /** @generated */
  final int     casFeatCode_temporalFunction;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTemporalFunction(int addr) {
        if (featOkTst && casFeat_temporalFunction == null)
      jcas.throwFeatMissing("temporalFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_temporalFunction);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTemporalFunction(int addr, String v) {
        if (featOkTst && casFeat_temporalFunction == null)
      jcas.throwFeatMissing("temporalFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_temporalFunction, v);}
    
  
 
  /** @generated */
  final Feature casFeat_anchorTimeID;
  /** @generated */
  final int     casFeatCode_anchorTimeID;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAnchorTimeID(int addr) {
        if (featOkTst && casFeat_anchorTimeID == null)
      jcas.throwFeatMissing("anchorTimeID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_anchorTimeID);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnchorTimeID(int addr, String v) {
        if (featOkTst && casFeat_anchorTimeID == null)
      jcas.throwFeatMissing("anchorTimeID", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_anchorTimeID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_valueFromFunction;
  /** @generated */
  final int     casFeatCode_valueFromFunction;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getValueFromFunction(int addr) {
        if (featOkTst && casFeat_valueFromFunction == null)
      jcas.throwFeatMissing("valueFromFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_valueFromFunction);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setValueFromFunction(int addr, String v) {
        if (featOkTst && casFeat_valueFromFunction == null)
      jcas.throwFeatMissing("valueFromFunction", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_valueFromFunction, v);}
    
  
 
  /** @generated */
  final Feature casFeat_functionInDocument;
  /** @generated */
  final int     casFeatCode_functionInDocument;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFunctionInDocument(int addr) {
        if (featOkTst && casFeat_functionInDocument == null)
      jcas.throwFeatMissing("functionInDocument", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_functionInDocument);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFunctionInDocument(int addr, String v) {
        if (featOkTst && casFeat_functionInDocument == null)
      jcas.throwFeatMissing("functionInDocument", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_functionInDocument, v);}
    
  
 
  /** @generated */
  final Feature casFeat_beginPoint;
  /** @generated */
  final int     casFeatCode_beginPoint;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getBeginPoint(int addr) {
        if (featOkTst && casFeat_beginPoint == null)
      jcas.throwFeatMissing("beginPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_beginPoint);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setBeginPoint(int addr, String v) {
        if (featOkTst && casFeat_beginPoint == null)
      jcas.throwFeatMissing("beginPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_beginPoint, v);}
    
  
 
  /** @generated */
  final Feature casFeat_endPoint;
  /** @generated */
  final int     casFeatCode_endPoint;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getEndPoint(int addr) {
        if (featOkTst && casFeat_endPoint == null)
      jcas.throwFeatMissing("endPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_endPoint);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEndPoint(int addr, String v) {
        if (featOkTst && casFeat_endPoint == null)
      jcas.throwFeatMissing("endPoint", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_endPoint, v);}
    
  
 
  /** @generated */
  final Feature casFeat_quant;
  /** @generated */
  final int     casFeatCode_quant;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getQuant(int addr) {
        if (featOkTst && casFeat_quant == null)
      jcas.throwFeatMissing("quant", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_quant);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuant(int addr, String v) {
        if (featOkTst && casFeat_quant == null)
      jcas.throwFeatMissing("quant", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_quant, v);}
    
  
 
  /** @generated */
  final Feature casFeat_freq;
  /** @generated */
  final int     casFeatCode_freq;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFreq(int addr) {
        if (featOkTst && casFeat_freq == null)
      jcas.throwFeatMissing("freq", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_freq);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFreq(int addr, String v) {
        if (featOkTst && casFeat_freq == null)
      jcas.throwFeatMissing("freq", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_freq, v);}
    
  
 
  /** @generated */
  final Feature casFeat_value;
  /** @generated */
  final int     casFeatCode_value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getValue(int addr) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setValue(int addr, String v) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Timex3Text;
  /** @generated */
  final int     casFeatCode_Timex3Text;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTimex3Text(int addr) {
        if (featOkTst && casFeat_Timex3Text == null)
      jcas.throwFeatMissing("Timex3Text", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Timex3Text);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTimex3Text(int addr, String v) {
        if (featOkTst && casFeat_Timex3Text == null)
      jcas.throwFeatMissing("Timex3Text", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setStringValue(addr, casFeatCode_Timex3Text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_checkMirror;
  /** @generated */
  final int     casFeatCode_checkMirror;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCheckMirror(int addr) {
        if (featOkTst && casFeat_checkMirror == null)
      jcas.throwFeatMissing("checkMirror", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    return ll_cas.ll_getIntValue(addr, casFeatCode_checkMirror);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCheckMirror(int addr, int v) {
        if (featOkTst && casFeat_checkMirror == null)
      jcas.throwFeatMissing("checkMirror", "de.unidue.langtech.teaching.ba.type.Timex3Gold");
    ll_cas.ll_setIntValue(addr, casFeatCode_checkMirror, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Timex3Gold_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tID = jcas.getRequiredFeatureDE(casType, "tID", "uima.cas.String", featOkTst);
    casFeatCode_tID  = (null == casFeat_tID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tID).getCode();

 
    casFeat_Timex3type = jcas.getRequiredFeatureDE(casType, "Timex3type", "uima.cas.String", featOkTst);
    casFeatCode_Timex3type  = (null == casFeat_Timex3type) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Timex3type).getCode();

 
    casFeat_mod = jcas.getRequiredFeatureDE(casType, "mod", "uima.cas.String", featOkTst);
    casFeatCode_mod  = (null == casFeat_mod) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mod).getCode();

 
    casFeat_temporalFunction = jcas.getRequiredFeatureDE(casType, "temporalFunction", "uima.cas.String", featOkTst);
    casFeatCode_temporalFunction  = (null == casFeat_temporalFunction) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_temporalFunction).getCode();

 
    casFeat_anchorTimeID = jcas.getRequiredFeatureDE(casType, "anchorTimeID", "uima.cas.String", featOkTst);
    casFeatCode_anchorTimeID  = (null == casFeat_anchorTimeID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_anchorTimeID).getCode();

 
    casFeat_valueFromFunction = jcas.getRequiredFeatureDE(casType, "valueFromFunction", "uima.cas.String", featOkTst);
    casFeatCode_valueFromFunction  = (null == casFeat_valueFromFunction) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_valueFromFunction).getCode();

 
    casFeat_functionInDocument = jcas.getRequiredFeatureDE(casType, "functionInDocument", "uima.cas.String", featOkTst);
    casFeatCode_functionInDocument  = (null == casFeat_functionInDocument) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_functionInDocument).getCode();

 
    casFeat_beginPoint = jcas.getRequiredFeatureDE(casType, "beginPoint", "uima.cas.String", featOkTst);
    casFeatCode_beginPoint  = (null == casFeat_beginPoint) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_beginPoint).getCode();

 
    casFeat_endPoint = jcas.getRequiredFeatureDE(casType, "endPoint", "uima.cas.String", featOkTst);
    casFeatCode_endPoint  = (null == casFeat_endPoint) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_endPoint).getCode();

 
    casFeat_quant = jcas.getRequiredFeatureDE(casType, "quant", "uima.cas.String", featOkTst);
    casFeatCode_quant  = (null == casFeat_quant) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_quant).getCode();

 
    casFeat_freq = jcas.getRequiredFeatureDE(casType, "freq", "uima.cas.String", featOkTst);
    casFeatCode_freq  = (null == casFeat_freq) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_freq).getCode();

 
    casFeat_value = jcas.getRequiredFeatureDE(casType, "value", "uima.cas.String", featOkTst);
    casFeatCode_value  = (null == casFeat_value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_value).getCode();

 
    casFeat_Timex3Text = jcas.getRequiredFeatureDE(casType, "Timex3Text", "uima.cas.String", featOkTst);
    casFeatCode_Timex3Text  = (null == casFeat_Timex3Text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Timex3Text).getCode();

 
    casFeat_checkMirror = jcas.getRequiredFeatureDE(casType, "checkMirror", "uima.cas.Integer", featOkTst);
    casFeatCode_checkMirror  = (null == casFeat_checkMirror) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_checkMirror).getCode();

  }
}



    