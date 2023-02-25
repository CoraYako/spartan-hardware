import { Button } from '@/components/common/Button'
import CardIcon from '@/public/icons/CardIcon'
import CheckedIcon from '@/public/icons/Checked'
import CheckedIconSquare from '@/public/icons/CheckedSquare'
import CrossIcon from '@/public/icons/Cross'
import DecrementIcon from '@/public/icons/DecrementIcon'
import HomeIcon from '@/public/icons/HomeIcon'
import IncrementIcon from '@/public/icons/IncrementIcon'
import ProductIcon from '@/public/icons/Product'
import TrackIcon from '@/public/icons/Track'
import FormatPrice from '@/utils/FormatPrice'
import { useState } from 'react'
import styled from 'styled-components'

export const Info = ({ data }) => {
  const [quantity, setQuantity] = useState(1)

  const handleIncrement = () => {
    if (quantity < data.quantity) {
      setQuantity(quantity + 1)
    }
  }

  const handleDecrement = () => {
    if (quantity > 1) {
      setQuantity(quantity - 1)
    }
  }
  return (
    <Container>
      <div className="price">
        <h2>${FormatPrice(data.specialPrice, false, quantity)}</h2>
        <h4>Precio especial</h4>
        <h4 className="list">
          Precio de lista: ${FormatPrice(data.price, false, quantity)}
        </h4>
      </div>
      <div className="info">
        <div className="info_container">
          <CardIcon />
          <div className="text">
            <h6>Financiación</h6>
          </div>
        </div>
        <div className="info_container">
          <TrackIcon />
          <div className="text">
            <h6>Envio a todo el pais</h6>
          </div>
        </div>
        <div className="info_container">
          <CheckedIcon />
          <div className="text">
            <h6>ULTIMAS {data.quantity} UNIDAD/ES</h6>
            <p>Solo para venta Online</p>
          </div>
        </div>
        <div className="info_container">
          <CheckedIconSquare />
          <div className="text">
            <h6>GARANTÍA</h6>
            <p>360 dias</p>
          </div>
        </div>
        <div className="info_container">
          <CrossIcon />
          <div className="text">
            <h6>SIN STOCK EN EL LOCAL</h6>
            <p>Solo venta presencial</p>
          </div>
        </div>
        <div className="info_container">
          <ProductIcon />
          <div className="text">
            <h6>SELLO DE GARANTIA MAXIMUS</h6>
            <p>Tu PC 100% asegurada</p>
          </div>
        </div>
        <div className="info_container">
          <HomeIcon />
          <div className="text">
            <h6>RETIRO GRATIS</h6>
            <p>Floresta y Local Galeria Jardin (CABA)</p>
          </div>
        </div>
      </div>
      <div className="action">
        <div className="line" />
        <div className="buttons">
          <QuantityContainer>
            <QuantityButtonLeft onClick={() => handleDecrement()}>
              <DecrementIcon />
            </QuantityButtonLeft>
            <QuantityValue>
              <p>{quantity}</p>
            </QuantityValue>
            <QuantityButtonRight onClick={() => handleIncrement()}>
              <IncrementIcon />
            </QuantityButtonRight>
          </QuantityContainer>
          <Button text="AÑADIR AL CARRITO" />
        </div>
      </div>
    </Container>
  )
}

const QuantityContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 1.4rem;
  background: #cdcdcd;
  border: 1px solid #b8b8b8;
  border-radius: 6px;
  width: 133px;
`

const QuantityButtonLeft = styled.button`
  width: 30px;
  height: 100%;
  border: none;
  background-color: transparent;
  font-size: inherit;
  cursor: pointer;
  background: #bfbfbf;
  box-shadow: 3px 0px 4px rgba(0, 0, 0, 0.15);
  border-radius: 6px 0px 0px 6px;
`
const QuantityButtonRight = styled.button`
  width: 30px;
  height: 100%;
  border: none;
  background-color: transparent;
  font-size: inherit;
  cursor: pointer;
  background: #bfbfbf;
  box-shadow: -3px 0px 4px rgba(0, 0, 0, 0.15);
  border-radius: 0px 6px 6px 0px;
`

const QuantityValue = styled.span`
  margin: 0 1rem;
`

const Container = styled.div`
  display: flex;
  flex-direction: column;
  padding: 25px 20px 25px 45px;
  .action {
    .buttons {
      display: flex;
      justify-content: center;
      margin: 30px;
      gap: 20px;
    }
    .line {
      width: 400px;
      border: 1px solid #8e8e8e;
      margin: auto;
    }
  }
  .list {
    margin-top: 8px;
  }
  .price {
    h2 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 34px;
      line-height: 30px;
    }
    h4 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 18px;
      line-height: 30px;
    }
  }

  .info {
    margin: 40px 0;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 25px 30px;
  }
  .info_container {
    display: flex;
    flex-direction: row;
    width: 260px;
    align-items: center;
    gap: 20px;
    p {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 400;
      font-size: 14px;
      line-height: 20px;
    }
    h6 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 14px;
      line-height: 20px;
    }
  }
`
