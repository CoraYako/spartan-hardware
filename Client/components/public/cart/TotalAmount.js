import { Button } from '@/components/common/Button'
import { CartContext } from '@/context/CartContext'
import DeleteIcon from '@/public/icons/Delete'
import FormatPrice from '@/utils/FormatPrice'
import { useContext } from 'react'
import styled from 'styled-components'
import { CartCard } from './CartCard'

export const TotalAmount = ({ checkout }) => {
  const { cart, emptyCart } = useContext(CartContext)
  const totalPrice = cart.reduce(
    (total, product) => total + product.price * product.quantityInCart,
    0,
  )
  return (
    <Container checkout={checkout}>
      <div className="top">
        <h4>RESUMEN DEL PEDIDO</h4>
      </div>
      <div className="bot">
        <h4>TOTAL: ${FormatPrice(totalPrice, 0, 1)}</h4>
        {!checkout && (
          <>
            <div className="empty_cart" onClick={() => emptyCart()}>
              <DeleteIcon />
            </div>
            <Button text="CONTINUAR" to="/checkout" />
          </>
        )}
        <div className="list">
          {cart &&
            checkout &&
            cart.map((item) => (
              <CartCard
                img={'http://' + item?.urlImages[0]?.slice(8)}
                id={item.id}
                name={item.name}
                price={item.price}
                quantity={item.quantityInCart}
                key={item.id}
                checkout
              />
            ))}
        </div>
      </div>
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  border-radius: 8px;
  border: 1px solid #9e9e9e;
  .list {
    margin: 15px 0 0 0;
    overflow-y: scroll;
    max-height: 350px;
    display: flex;
    flex-direction: column;
    gap: 15px;
    border-radius: 8px;
  }
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
    flex-direction: ${(props) => (props.checkout ? 'column' : 'row')};
    align-items: center;
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
