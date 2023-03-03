import { Button } from '@/components/common/Button'
import { CartContext } from '@/context/CartContext'
import DeleteIcon from '@/public/icons/Delete'
import FormatPrice from '@/utils/FormatPrice'
import { useContext } from 'react'
import styled from 'styled-components'

export const TotalAmount = () => {
  const { cart, emptyCart } = useContext(CartContext)
  const totalPrice = cart.reduce((total, product) => total + product.price, 0)
  return (
    <Container>
      <div className="top">
        <h4>RESUMEN DEL PEDIDO</h4>
      </div>
      <div className="bot">
        <h4>TOTAL: ${FormatPrice(totalPrice, 0, 1)}</h4>
        <div className="empty_cart" onClick={() => emptyCart()}>
          <DeleteIcon />
        </div>
        <Button text="CONTINUAR" />
      </div>
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  border-radius: 8px;
  border: 1px solid #9e9e9e;
  .empty_cart {
    padding: 10px;
    background: #de0303;
    border-radius: 3px;
    margin: 0 12px;
    cursor: pointer;
  }
  .top {
    padding: 14px 16px;
    background: #120628;
    border-radius: 8px 8px 0px 0px;
    h4 {
      font-style: normal;
      font-weight: 700;
      font-size: 20px;
      line-height: 26px;
      color: #16e000;
    }
  }
  .bot {
    padding: 20px 16px 14px 16px;
    display: flex;
    flex-direction: row;
    h4 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 20px;
      line-height: 26px;
      margin: 0 auto 0 0;
    }
  }
`
