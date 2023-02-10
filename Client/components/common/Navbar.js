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
        <div className="left-side">
          <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ duration: 0.5, delay: 0.2 }}
          >
            <Link passHref href="/">
              <Image src={Logo} width={160} height={40} alt="logo" />
            </Link>
          </motion.div>
          <SearchNav />
        </div>
        <MenuNav />
      </div>
      <Submenu />
    </Nav>
  )
}

const Nav = styled.nav`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  position: fixed;
  top: 0;
  z-index: 10;
  .container-nav {
    background-color: var(--secondaryViolet1);
    padding: 2.3rem 2.2rem;
    height: 8.8rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
  }
  .left-side {
    display: flex;
    flex-direction: row;
    width: auto;
    gap: 3.5rem;
    align-items: center;
  }
`
