import { CartContext } from '@/context/CartContext'
import { useContext } from 'react'
import styled from 'styled-components'
import { TotalAmount } from '../cart/TotalAmount'
import { CarouselProduct } from '../Product/CarouselProduct'
import { Steps } from './Steps'

export const CheckoutContent = () => {
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
      <h2>Estas a punto de terminar tu compra!</h2>
      <div className="cart">
        <div className="steps">
          <Steps />
        </div>
        <div className="details">
          <div className="product">
            <CarouselProduct images={images} />
          </div>
          <div className="total_amount">
            <TotalAmount checkout />
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
  .steps {
    min-width: 760px;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
`
