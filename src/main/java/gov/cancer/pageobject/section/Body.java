package gov.cancer.pageobject.section;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;

/*
 * r 
 */
public class Body {
  
 
    
 public String bodyHeaders = ".accordion section h2";
 
 private WebElement otpSection;
 
  public Body(WebElement element) {
    
  }
  
  
  public List<Body> getH2List(){
    
    List<Body> otpLinks = new ArrayList<Body>();

    List<WebElement> rawLinks = ElementHelper.findElements(otpSection, bodyHeaders);
  
    System.out.println(ElementHelper.findElements(otpSection, bodyHeaders));

    for (WebElement link : rawLinks) {

      otpLinks.add(new Body(link));
    }
    return otpLinks;
  }
  
  
 
    
  }

