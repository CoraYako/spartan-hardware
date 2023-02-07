import styled from 'styled-components'
import { motion } from 'framer-motion'
import ImageMock from '@/public/images/img_keyboard_test.png'
import Image from 'next/image'

export const ProductCard = ({ img, title, details, price }) => {
  return (
    <CardContainer whileHover={{ scale: 1.05 }} whileTap={{ scale: 0.99 }}>
      <div className="top-info">
        <Image src={ImageMock} />
        <span className="divider" />
        <h3>{title}</h3>
      </div>
    </CardContainer>
  )
}

const CardContainer = styled(motion.article)`
  height: 53rem;
  width: 33rem;
  box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
  margin: 3rem auto;
  background-color: var(--gray4);
`
