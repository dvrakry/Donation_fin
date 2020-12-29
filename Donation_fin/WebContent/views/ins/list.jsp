<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="blog_categorie_area">
    <div class="container">
      <div class="row">
      <c:forEach items="${iList }" var="ivo">
        <div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
            <div class="categories_post mb-4">            
                <img class="card-img rounded-0" src="upload/${ivo.thumb }" style="width:350px; height:210px;" >
                <div class="categories_details">
                    <div class="categories_text">
                        <a href="./ins?sv=detail&ino=${ivo.ino }">
                            <h5>${ivo.iname }</h5>
                        </a>
                        <div class="border_line"></div>
                        <p>${ivo.loc }</p>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
      </div>
      <c:if test="${ses.mid eq 'admin'}"> 
      <table class="table">
      <tbody>
      <tr class="out_button_area">
                              <td class="d-none-l">
                              </td>
                              <td class="">
                              </td>
                              <td>
                              </td>
                              <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
                              <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>
                                  <div class="checkout_btn_inner d-flex align-items-center">
                                      <a class="gray_btn" href="index.jsp?rp=iReg">시설 등록</a>
                                  </div>
                              </td>
                          </tr>
                          </tbody></table>
                          </c:if>
    </div>
  </section>