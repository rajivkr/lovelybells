package  com.diaries.wedding.model;
import java.util.*;

public class FeatureValue {

private String featureCategoryTitle;
private List<FeatureCategoryValues> featureCategoryValues;


public void setFeatureCategoryTitle(String FeatureCategoryTitle){
    this.featureCategoryTitle = FeatureCategoryTitle;
}
public String getFeatureCategoryTitle(){
    return this.featureCategoryTitle;
}
public void setFeatureCategoryValues(List<FeatureCategoryValues> FeatureCategoryValues){
    this.featureCategoryValues = FeatureCategoryValues;
}
public List<FeatureCategoryValues> getFeatureCategoryValues(){
    return this.featureCategoryValues;
}
}
