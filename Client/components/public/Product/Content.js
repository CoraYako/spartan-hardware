import GraphicsIcon from '@/public/icons/Graphics'
import ProcessorIcon from '@/public/icons/Processor'
import RamIcon from '@/public/icons/Ram'
import StorageIcon from '@/public/icons/Storage'
import FormatPrice from '@/utils/FormatPrice'
import styled from 'styled-components'
import { CarouselProduct } from './CarouselProduct'
import { Info } from './Info'

export const Content = ({ data }) => {
  return (
    <Container>
      <div className="bar">
        <div className="info">
          <ProcessorIcon />
          <p> {data.brand}</p>
        </div>
        <div className="info">
          <RamIcon />
          <p>{data.category}</p>
        </div>
        <div className="info">
          <StorageIcon />
          <p>{data.subCategory}</p>
        </div>
        <div className="info">
          <GraphicsIcon />
          <p>{data.model}</p>
        </div>
        <div className="triangle_top" />
        <div className="triangle_bot" />
      </div>
      <div className="left">
        <h2 className="name_product">{data.name}</h2>
        <p className="detail">
          12 cuotas sin interés de {FormatPrice(data.price, true)} a precio de
          lista
        </p>
        <CarouselProduct />
      </div>
      <div className="right">
        <Info data={data} />
      </div>
    </Container>
  )
}

const Container = styled.div`
  max-width: 1300px;
  margin: 50px auto;
  height: 680px;
  display: flex;
  flex-direction: row;
  position: relative;
  border: 1px solid #cecece;
  border-radius: 8px;
  background: linear-gradient(
    270deg,
    rgba(209, 209, 209, 0.17) 0%,
    #b6b6b6 59.44%
  );
  .right {
    width: 620px;
  }
  .bar {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 40px;
    position: absolute;
    width: 640px;
    height: 93px;
    background-color: #cecece;
    bottom: 40px;
    .info {
      max-width: 90px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 10px;
      p {
        font-family: 'Raleway';
        font-style: normal;
        font-weight: 600;
        font-size: 14px;
        line-height: 15px;
        text-align: center;
      }
    }
    .triangle_top {
      position: absolute;
      right: 8px;
      top: -20px;
      width: 0;
      height: 0;
      border-top: 15px solid transparent;
      border-bottom: 15px solid transparent;
      border-left: 15px solid #343434;
      transform: rotate(134deg);
    }
    .triangle_bot {
      position: absolute;
      width: 0;
      height: 0;
      bottom: -20px;
      right: 8px;
      border-top: 15px solid transparent;
      border-bottom: 15px solid transparent;
      border-left: 15px solid #343434;
      transform: rotate(-135deg);
    }
  }
  .left {
    border-radius: 8px 0 0 8px;
    display: flex;
    flex-direction: column;
    background: #120628;
    box-shadow: 5px 0px 9px rgba(0, 0, 0, 0.25);
    padding: 22px 26px;
    width: 620px;
  }
  .name_product {
    font-style: normal;
    font-weight: 700;
    font-size: 23px;
    line-height: 30px;
    color: #fff;
    max-width: 450px;
  }
  .detail {
    font-style: normal;
    font-weight: 700;
    font-size: 13px;
    line-height: 40px;
    color: #fff;
  }
`
