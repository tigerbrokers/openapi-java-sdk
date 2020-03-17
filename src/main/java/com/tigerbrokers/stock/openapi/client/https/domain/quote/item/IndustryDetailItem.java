package com.tigerbrokers.stock.openapi.client.https.domain.quote.item;

import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.struct.enums.IndustryLevel;

/**
 * Description:
 *
 * @author kevin
 */
public class IndustryDetailItem extends ApiModel {

  private String id;
  private IndustryLevel industryLevel;
  private String nameCN;
  private String nameEN;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public IndustryLevel getIndustryLevel() {
    return industryLevel;
  }

  public void setIndustryLevel(IndustryLevel industryLevel) {
    this.industryLevel = industryLevel;
  }

  public String getNameCN() {
    return nameCN;
  }

  public void setNameCN(String nameCN) {
    this.nameCN = nameCN;
  }

  public String getNameEN() {
    return nameEN;
  }

  public void setNameEN(String nameEN) {
    this.nameEN = nameEN;
  }

  @Override
  public String toString() {
    return "IndustryDetailItem{" +
        "id='" + id + '\'' +
        ", industryLevel=" + industryLevel +
        ", nameCN='" + nameCN + '\'' +
        ", nameEN='" + nameEN + '\'' +
        '}';
  }
}
