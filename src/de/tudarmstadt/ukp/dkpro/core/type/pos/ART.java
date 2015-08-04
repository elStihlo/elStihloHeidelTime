

/* First created by JCasGen Mon May 02 14:10:48 CEST 2011 */
package de.tudarmstadt.ukp.dkpro.core.type.pos;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import de.tudarmstadt.ukp.dkpro.core.type.POS;


/** Article
 * Updated by JCasGen Mon May 02 14:13:32 CEST 2011
 * XML source: /home/jstroetgen/workspace/heideltime-kit/desc/annotator/AnnotationTranslater.xml
 * @generated */
public class ART extends POS {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(ART.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ART() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ART(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ART(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public ART(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
}

    