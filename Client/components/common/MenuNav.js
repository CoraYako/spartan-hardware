import AccountIcon from '@/public/icons/Account'
import CartIcon from '@/public/icons/Cart'
import styled from 'styled-components'
import { motion } from 'framer-motion'
import Link from 'next/link'

export const MenuNav = () => {
  return (
    <Container
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.5, delay: 1.3 }}
    >
      <Link passHref href="/login">
        <Item>
          <AccountIcon />
          Mi cuenta
        </Item>
      </Link>
      <Item>
        <CartIcon />
        Mi carrito
      </Item>
    </Container>
  )
}

const Container = styled(motion.div)`
  color: #fff;
  display: flex;
  align-items: center;
  gap: 6rem;
`

const Item = styled.div`
  display: flex;
  align-items: center;
  cursor: pointer;
`
