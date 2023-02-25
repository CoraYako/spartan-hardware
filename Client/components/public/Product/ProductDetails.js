import styled from 'styled-components'
import { motion } from 'framer-motion'
import { useState } from 'react'

const variants = {
  open: { opacity: 1, translateX: '-10px', position: 'absolute' },
  closed: { opacity: 1, x: '100%', position: 'absolute' },
}

export const ProductDetails = ({ data }) => {
  const [isOpen, setIsOpen] = useState(false)

  return (
    <Container
      animate={isOpen ? 'open' : 'closed'}
      variants={variants}
      onClick={() => setIsOpen(!isOpen)}
    >
      <div className="nav">
        <div className="triangle" />
        <h4>Especificacioines Tecnicas</h4>
      </div>
      <div className="details">
        <p>{data}</p>
      </div>
    </Container>
  )
}

const Container = styled(motion.div)`
  position: absolute;
  background: #d1d1d1 !important;
  right: 0;
  height: auto;
  max-width: 400px;
  z-index: 2;
  top: 250px;
  border-radius: 16px;
  transform: translateX(-20px);
  .details {
    padding: 9px 14px 17px;
    p {
      font-weight: 400;
      font-size: 18px;
      line-height: 25px;
    }
  }
  .nav {
    cursor: pointer;
    height: 35px;
    transform: translateX(-50px);
    width: 117%;
    border-radius: 8px 0 0 8px;
    background: #120628;
    display: flex;
    align-items: center;
    gap: 30px;
    color: #fff;
    padding: 7px 14px;
  }

  .triangle {
    width: 0;
    height: 0;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-right: 16px solid #25da2d;
  }
`
