import React from 'react'
// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react'

// Import Swiper styles
import 'swiper/css'
import 'swiper/css/pagination'
import styled from 'styled-components'

// import required modules
import { Autoplay, Pagination } from 'swiper'
import Image from 'next/image'

export const CarouselProduct = ({ images, name }) => {
  return (
    <CustomSwiper
      pagination={{
        clickable: true,
      }}
      centeredSlides={true}
      modules={[Pagination, Autoplay]}
      className="mySwiper"
      slidesPerView={3}
      spaceBetween={30}
      autoplay={{
        delay: 1000,
        disableOnInteraction: true,
      }}
    >
      {images &&
        images.map((item) => (
          <SwiperSlide key={item.id}>
            <h2> {item.name}</h2>
            <Image src={item.images} alt="product" />
          </SwiperSlide>
        ))}
    </CustomSwiper>
  )
}

const CustomSwiper = styled(Swiper)`
  height: 400px;
  max-width: 550px;
  .swiper-wrapper {
    height: 350px;
  }
  .swiper-slide {
    color: #fff;
    display: flex;
    flex-direction: column;
    position: relative;
    align-items: center;
    justify-content: center;
    transform: scale(0.75);
    opacity: 0.5;
    filter: blur(4px);
    h2 {
      visibility: hidden;
    }
  }
  .swiper-slide-active {
    transform: scale(1);
    opacity: 1;
    filter: blur(0px);
    h2 {
      position: absolute;
      top: 0px;
      width: 380px;
      left: -160px;
      visibility: visible;
    }
  }
  .swiper-pagination-bullet {
    background: #25da2d;
    width: 15px;
    height: 15px;
    margin: 0 10px !important;
  }
`
