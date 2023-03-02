import CrossIcon from '@/public/icons/Cross'
import Image from 'next/image'
import styled from 'styled-components'
import MockImage from '@/public/images/MockImage1.png'
import FormatPrice from '@/utils/FormatPrice'
import { useContext } from 'react'
import { CartContext } from '@/context/CartContext'

export const CartCard = ({
  img,
  name = 'intel XD',
  price = 200000,
  quantity = 1,
  id = 1,
  checkout,
}) => {
  const { removeFromCart } = useContext(CartContext)
  return (
    <Card checkout={checkout}>
      <div className="image">
        <Image src={img || MockImage} alt="product" />
      </div>
      <div className="divider" />
      <h6>{name}</h6>
      <div className="info">
        <div className="quantity">
          <h6>{quantity}</h6>
        </div>
        <h5>${FormatPrice(price, false, quantity)}</h5>
      </div>
      <CrossIcon onClick={() => removeFromCart(id)} />
    </Card>
  )
}

const Card = styled.div`
  width: auto;
  display: flex;
  flex-direction: row;
  align-items: center;
  position: relative;
  min-height: 152px;
  background: #ffffff;
  border-bottom: 1px solid #a3a3a3;
  border-radius: 8px;
  .quantity {
    width: 50px;
    height: 50px;
    border: 1px solid #16e000;
    border-radius: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
    h6 {
      margin: 0;
    }
  }
  .info {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: ${(props) => (props.checkout ? '0 10px' : ' 0 64px 0 0')};
    gap: 20px;
  }
  .image {
    padding: ${(props) => (props.checkout ? '0 10px' : '0 40px')};
    border-right: 1px solid #b7b7b799;
  }
  h5 {
    font-family: 'Raleway';
    font-style: normal;
    font-weight: 600;
    font-size: 20px;
    line-height: 26px;
    color: #120628;
  }
  h6 {
    margin: 0 auto 0 30px;
    font-style: normal;
    font-weight: 600;
    font-size: 16px;
    line-height: 26px;
  }

  img {
    max-width: 100px;
    max-height: 100px;
  }

  svg {
    cursor: pointer;
    position: absolute;
    opacity: 0.3;
    top: 1px;
    right: 1px;
    transform: scale(0.7);
  }
`
