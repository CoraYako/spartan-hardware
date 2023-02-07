import Image from 'next/image'
import styled from 'styled-components'
import Logo from '@/public/images/main-logo.png'
import { SearchNav } from './SearchNav'
import { MenuNav } from './MenuNav'
import { motion } from 'framer-motion'
import { Submenu } from './SubMenu/Submenu'
import Link from 'next/link'

export const Navbar = () => {
  return (
    <Nav>
      <div className="container-nav">
        <motion.div
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 0.5, delay: 0.2 }}
        >
          <Link passHref href="/">
            <Image src={Logo} width={60} height={60} alt="logo" />
          </Link>
        </motion.div>
        <SearchNav />
        <MenuNav />
      </div>
      <Submenu />
    </Nav>
  )
}

const Nav = styled.nav`
  height: 15rem;
  background-color: var(--mainBlack);
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  position: relative;

  .container-nav {
    padding: 0.5rem 4rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    margin: auto 0;
  }
`
