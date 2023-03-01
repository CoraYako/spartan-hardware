import { CartContext } from '@/context/CartContext'
import React, { useContext } from 'react'
import styled from 'styled-components'
import { CartCard } from './CartCard'

export const CartSection = () => {
  const { cart } = useContext(CartContext)
  return (
    <Container>
      <h2>Productos agregados en tu compra</h2>
      <div className="cart">
        <div className="list_cart">
          {cart &&
            cart.map((item) => (
              <CartCard
                img={item.img}
                id={item.id}
                name={item.title}
                price={item.price}
                quantity={item.quantityInCart}
                key={item.id}
              />
            ))}
        </div>
        <div className="details">
          <div className="product"></div>
          <div className="total_amount"></div>
        </div>
      </div>
    </Container>
  )
}

const Container = styled.div`
  max-width: 1300px;
  display: flex;
  flex-direction: column;
  margin: 10px auto 0;
  padding: 0 2.5rem;

  .cart {
    margin: 40px 0 0;
  }
  .list_cart {
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 15px;
    max-height: 600px;
    overflow-y: scroll;
  }
`
