import AccountIcon from '@/public/icons/Account'
import CartIcon from '@/public/icons/Cart'
import styled from 'styled-components'
import { motion } from 'framer-motion'

import { GlobalContext } from '@/context/GlobalContext'
import { useContext } from 'react'
import { UserContext } from '@/context/UserContext'

export const MenuNav = () => {
  const { contextDataGlobal, setContextDataGlobal } = useContext(GlobalContext)
  const { user } = useContext(UserContext)
  return (
    <Container
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.5, delay: 1 }}
    >
      <Item
        onClick={() =>
          user
            ? null
            : setContextDataGlobal({
                ...contextDataGlobal,
                showModal: true,
                modalActive: 'login',
              })
        }
      >
        <span className="bar" />
        <AccountIcon />
        <p>{user ? user?.firstName : 'Mi cuenta'}</p>
      </Item>
      <Item>
        <span className="bar" />
        <CartIcon />
        <p>Mi carrito</p>
      </Item>
      <motion.div whileHover={{ scale: 1.1 }} className="number-cart">
        <p>10</p>
      </motion.div>
    </Container>
  )
}

const Container = styled(motion.div)`
  color: #fff;
  display: flex;
  align-items: center;
  gap: 0.9rem;
  .number-cart {
    cursor: pointer;
    background-color: var(--primaryGreen1);
    color: var(--secondaryViolet1);
    padding: 12px;
    border-radius: 6px;
    margin-left: 1rem;
  }
`

const Item = styled.div`
  display: flex;
  align-items: center;
  cursor: pointer;
  transition: all ease-in-out 0.3s;

  path {
    transition: all 0.3s ease-in-out;
  }
  .bar {
    width: 1px;
    height: 5rem;
    background-color: #989898;
    margin-right: 1rem;
  }
  &:hover {
    color: var(--primaryGreen1);
    .bar {
      background-color: var(--primaryGreen1);
    }
    path {
      fill: var(--primaryGreen1);
    }
  }
`
