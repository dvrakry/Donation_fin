<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="hero-banner">
      <div class="container">
        <div class="row no-gutters align-items-center pt-60px">
          <div class="col-5 d-none d-sm-block">
            <div class="hero-banner__img">
              <img class="img-fluid" src="img/home/hero-banner.png" alt="">
            </div>
          </div>
          <div class="col-sm-7 col-lg-6 offset-lg-1 pl-4 pl-md-5 pl-lg-0">
            <div class="hero-banner__content">
              <h4>수정페이지</h4>
               <p>Us which over of signs divide dominion deep fill bring they're meat beho upon own earth without morning over third. Their male dry. They are great appear whose land fly grass.</p>
            </div>
          </div>
        </div>
      </div>
    </section>
<hr>
<hr>
<c:set var="ses" value="${ses_mvo }" scope="session" />
<div class="row">
        <div class="col-md-4 col-lg-3 mb-4 mb-md-0">
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-home"></i></span>
            <div class="media-body">
              <h3>시설회원 ID</h3>
              <p>Santa monica bullevard</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-email"></i></span>
            <div class="media-body">
              <h3><a href="mailto:support@colorlib.com">시설이름</a></h3>
              <p>Send us your query anytime!</p>
            </div>
          </div>
          <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-email"></i></span>
            <div class="media-body">
              <h3><a href="mailto:support@colorlib.com">후원자</a></h3>
              <p>Send us your query anytime!</p>
            </div>
          </div>
            <div class="media contact-info">
            <span class="contact-info__icon"><i class="ti-email"></i></span>
            <div class="media-body">
              <h3><a href="mailto:support@colorlib.com">사진첨부</a></h3>
              <p>Send us your query anytime!</p>
            </div>
          </div>
        </div>
        <div class="col-md-8 col-lg-9">
          <form action="./board?sv=update&bno=${bvo.bno }" class="form-contact contact_form" action="contact_process.php" method="post" 
          id="contactForm" novalidate="novalidate" enctype="multipart/form-data">
            <div class="row">
              <div class="col-lg-5">
                <div class="form-group">
                  <input class="form-control" name="mid" id="mid" type="text"  value="${ses.mid }" readonly>
                </div>
                <div class="form-group">
                  <input class="form-control" name="mins" id="mins" type="text" value="${ses.mins }" readonly>
                </div>
                <div class="form-group">
                  <input class="form-control" name="bperson" id="bperson" type="text" value="${bvo.bperson }"
                  onfocus="this.value=''">
                </div>
                <div class="form-group">
                  <input class="form-control" name="imgfile2" id="imgfile" type="file">
                  <input type="hidden" name="imgfile" value="${bvo.imgfile }">
                  <input type="hidden" name="thumb" value="${bvo.thumb }">
                </div>
              </div>
              <div class="col-lg-7">
                <div class="form-group">
                    <input class="form-control" name="bcontent" id="bcontent" type="text"
                    value="${bvo.bcontent }"></input>
                </div>
              </div>
            </div>
            <div class="form-group text-center text-md-right mt-3">
              <button type="submit" class="button button--active button-contactForm">수정하기</button>
            </div>
          </form>
        </div>
      </div>