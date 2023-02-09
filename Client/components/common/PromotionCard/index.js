import styled from 'styled-components'
import { motion } from 'framer-motion'
import ImageMock from '@/public/images/test_img_font.png'
import Image from 'next/image'
import { Details } from '@/components/common/ProductCard/Details'
import { Label } from '../Label'

export const PromotionCard = ({
  img,
  title,
  details,
  isLoading,
  typeLabel = 'promotion' || 'outstanding' || 'shipping',
  msgLabel,
}) => {
  return (
    <CardContainer whileHover={{ scale: 1.05 }}>
      {typeLabel && <Label typeLabel={typeLabel} msg={msgLabel} />}
      <div className="top-info">
        <Image src={img || ImageMock} alt="image-name" className="image" />
        <div className="divider" />
        <div className="text">
          <h3>{title || 'Fuente 450w Gigabyte'}</h3>
          <Details details={details} alignItems="center" byPromotion />
        </div>
      </div>
    </CardContainer>
  )
}

const CardContainer = styled(motion.article)`
  position: relative;
  height: auto;
  width: 29.4rem;
  box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
  background-color: var(--gray4);
  padding: 0 0 2.4rem 0;
  cursor: pointer;

  .image {
    padding: 2.4rem 1.7rem 1rem;
    max-width: 265px;
  }

  .divider {
    width: 100%;
    margin: auto;
    border: 1px solid #c6c6c6;
  }

  .text {
    display: flex;
    flex-direction: column;
    margin-top: 1rem;
  }

  .top-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 0 2.5rem;
    height: 100%;
  }
  .button-container {
    display: flex;
    padding: 2.5rem 3.5rem;
    justify-content: space-between;
  }
`
