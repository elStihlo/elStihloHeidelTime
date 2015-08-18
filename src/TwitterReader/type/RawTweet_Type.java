
/* First created by JCasGen Mon Aug 17 14:01:15 CEST 2015 */
package TwitterReader.type;

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
 * Updated by JCasGen Mon Aug 17 14:01:15 CEST 2015
 * @generated */
public class RawTweet_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (RawTweet_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = RawTweet_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new RawTweet(addr, RawTweet_Type.this);
  			   RawTweet_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new RawTweet(addr, RawTweet_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RawTweet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("TwitterReader.type.RawTweet");
 
  /** @generated */
  final Feature casFeat_rawTweet;
  /** @generated */
  final int     casFeatCode_rawTweet;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRawTweet(int addr) {
        if (featOkTst && casFeat_rawTweet == null)
      jcas.throwFeatMissing("rawTweet", "TwitterReader.type.RawTweet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_rawTweet);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRawTweet(int addr, String v) {
        if (featOkTst && casFeat_rawTweet == null)
      jcas.throwFeatMissing("rawTweet", "TwitterReader.type.RawTweet");
    ll_cas.ll_setStringValue(addr, casFeatCode_rawTweet, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public RawTweet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_rawTweet = jcas.getRequiredFeatureDE(casType, "rawTweet", "uima.cas.String", featOkTst);
    casFeatCode_rawTweet  = (null == casFeat_rawTweet) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rawTweet).getCode();

  }
}



    