import { AnimatePresence } from 'framer-motion'
import styled from 'styled-components'
import { Navbar } from './Navbar'

const Layout = ({ children }) => {
  return (
    <PageContainer>
      <Navbar />
      <AnimatePresence mode="wait">{children}</AnimatePresence>
      {/* FOOTER */}
    </PageContainer>
  )
}

export default Layout

const PageContainer = styled.div`
  background-color: var(--mainBg);
  height: 100%;
  width: 100%;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`
