import Image from 'next/image'
import styled from 'styled-components'
import Logo from '@/public/images/main-logo.png'
import { SearchNav } from './SearchNav'
import { MenuNav } from './MenuNav'
import { motion } from 'framer-motion'

export const Navbar = () => {
  return (
    <Nav>
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5, delay: 0.2 }}
      >
        <Image src={Logo} width={60} height={60} alt="logo" />
      </motion.div>
      <SearchNav />
      <MenuNav />
    </Nav>
  )
}

const Nav = styled.nav`
  height: 10rem;
  background-color: var(--gray1);
  width: 100%;
  padding: 0.5rem 4rem;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
`
