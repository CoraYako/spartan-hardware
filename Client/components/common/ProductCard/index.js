import styled from 'styled-components'
import { motion } from 'framer-motion'
import ImageMock from '@/public/images/img_keyboard_test.png'
import Image from 'next/image'
import { Details } from './Details'
import { Button } from '../Button'
import { Label } from '../Label'

export const ProductCard = ({
  img,
  title,
  details,
  price,
  isLoading,
  promotion,
  fastSend,
  margin,
  bypcbuild = false,
}) => {
  return (
    <CardContainer
      whileHover={{ scale: 1.05 }}
      margin={margin}
      bypcbuild={bypcbuild ? 1 : 0}
    >
      {promotion && <Label typeLabel="promotion" msg="Promoción" />}
      {fastSend && <Label typeLabel="shipping" msg="Entrega inmediata" />}
      <div className="top-info">
        <Image src={img || ImageMock} alt="image-name" />
        <div className="divider" />
        <div className="text">
          <h3>{title || 'Teclado Mecanico Redragon Draconic K530'}</h3>
          <Details details={details} />
        </div>
      </div>
      <div className="price">
        <h3>$ 12.150</h3>
      </div>
      <div className="info">
        <p>No aplica impuestos</p>
      </div>
      <div className="button-container">
        {bypcbuild ? (
          <Button text="SUMAR AL CARRITO" />
        ) : (
          <>
            <Button text="Detalle" />
            <Button text="Cotizar" />
          </>
        )}
      </div>
    </CardContainer>
  )
}

const CardContainer = styled(motion.article)`
  width: 29.4rem;
  max-height: 510px;
  box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
  margin: ${(props) => (props.margin ? props.margin : '3rem 0')};
  background-color: var(--gray4);
  position: relative;

  .price {
    background-color: var(--primaryGreen1);
    text-align: center;
    padding: 1.25rem 0;
    margin-top: 2.5rem;
  }
  .divider {
    width: 100%;
    margin: auto;
    border: 1px solid #c6c6c6;
  }
  .text {
    display: flex;
    flex-direction: column;
    margin-top: 2.2rem;
  }

  .top-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 0 2.5rem;
  }
  .info {
    padding: 0 2.5rem;
    margin-top: 1rem;
  }
  .button-container {
    display: flex;
    padding: 2.5rem 3.5rem;
    justify-content: ${(props) =>
      props.bypcbuild ? 'center' : 'space-between'};
  }
`
