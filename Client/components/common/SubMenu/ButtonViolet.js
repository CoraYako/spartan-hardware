import Link from 'next/link'
import styled from 'styled-components'
import { motion } from 'framer-motion'

export const ButtonViolet = () => {
  return (
    <Container
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.5, delay: 2 }}
    >
      <Link passHref href="#">
        <p> ARMA TU PC</p>
        <div className="gradient" />
      </Link>
    </Container>
  )
}

const Container = styled(motion.div)`
  width: auto;
  padding: 12px 7px;
  background-color: #761ff5;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 7rem 0 0;
  position: relative;
  cursor: pointer;
  z-index: 50;

  p {
    color: #fff;
    font-weight: 700;
    text-align: center;
    font-size: 13px;
    text-align: center;
  }
  .gradient {
    width: 0;
    height: 0;
    border-left: 46px solid transparent;
    border-right: 46px solid transparent;
    border-top: 20px solid #761ff5;
    filter: drop-shadow(0px 6px 3px rgba(0, 0, 0, 0.5));
    height: 0px;
    margin-right: auto;
    margin-left: auto;
    top: 50px;
    right: 0;
    position: absolute;
    z-index: 0;
  }
`
