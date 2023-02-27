import React from 'react'
// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react'

// Import Swiper styles
import 'swiper/css'
import 'swiper/css/pagination'
import styled from 'styled-components'
import MockImage from '@/public/images/mockBaner.png'

// import required modules
import { Autoplay, Pagination } from 'swiper'
import Image from 'next/image'

export const CarouselProduct = () => {
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
        delay: 2500,
        disableOnInteraction: true,
      }}
    >
      <SwiperSlide>
        <Image src={MockImage} />
      </SwiperSlide>
      <SwiperSlide>
        <Image src={MockImage} />
      </SwiperSlide>
      <SwiperSlide>
        <Image src={MockImage} />
      </SwiperSlide>
      <SwiperSlide>
        <Image src={MockImage} />
      </SwiperSlide>
      <SwiperSlide>
        <Image src={MockImage} />
      </SwiperSlide>
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
    display: flex;
    align-items: center;
    justify-content: center;
    transform: scale(0.8);
    opacity: 0.5;
    filter: blur(4px);
  }
  .swiper-slide-active {
    transform: scale(1);
    opacity: 1;
    filter: blur(0px);
  }
  .swiper-pagination-bullet {
    background: #25da2d;
    width: 15px;
    height: 15px;
    margin: 0 10px !important;
  }
`
