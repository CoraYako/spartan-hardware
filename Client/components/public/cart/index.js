import { CartContext } from '@/context/CartContext'
import React, { useContext } from 'react'
import styled from 'styled-components'
import { CarouselProduct } from '../Product/CarouselProduct'
import { CartCard } from './CartCard'
import { TotalAmount } from './TotalAmount'

export const CartSection = () => {
  const { cart } = useContext(CartContext)
  const images = cart.map((item) => {
    return {
      images: item.img,
      name: item.title,
      id: item.id,
    }
  })

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
          {cart.length === 0 && <h2>Carrito vacio!</h2>}
        </div>
        <div className="details">
          <div className="product">
            <CarouselProduct images={images} />
          </div>
          <div className="total_amount">
            <TotalAmount />
          </div>
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

  .details {
    display: flex;
    flex-direction: column;
    gap: 20px;
  }

  .product {
    width: 500px;
    background-color: #120628;
    border-radius: 8px;
    padding: 25px;
  }

  .cart {
    margin: 40px 0 0;
    display: flex;
    flex-direction: row;
    gap: 25px;
  }
  .list_cart {
    min-width: 760px;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 15px;
    max-height: 600px;
    overflow-y: scroll;
  }
`
