import styled from 'styled-components'
import { CarouselProduct } from './CarouselProduct'

export const Content = () => {
  return (
    <Container>
      <div className="left">
        <h2 className="name_product">
          PC de Escritorio Armada Completa Intel Celeron G5905 8GB SSD 240GB
        </h2>
        <p className="detail">
          12 cuotas sin interés de $12.690,19 a precio de lista
        </p>
        <CarouselProduct />
      </div>
      <div></div>
    </Container>
  )
}

const Container = styled.div`
  max-width: 1300px;
  padding: 0 20px;
  margin: 50px 0;
  height: 680px;
  display: flex;
  flex-direction: row;
  .left {
    display: flex;
    flex-direction: column;
    background: #120628;
    box-shadow: 5px 0px 9px rgba(0, 0, 0, 0.25);
    padding: 22px 26px;
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
