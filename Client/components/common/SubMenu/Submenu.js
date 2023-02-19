import styled from 'styled-components'
import { useCycle } from 'framer-motion'
import { MenuButton } from './MenuButton'
import { HiddenMenu } from './HiddenMenu'
import { ButtonViolet } from './ButtonViolet'
import { motion } from 'framer-motion'

export const Submenu = () => {
  const [open, cycleOpen] = useCycle(false, true)
  return (
    <Container
      initial={{ opacity: 1, height: '0' }}
      animate={{ opacity: 1, height: '5rem' }}
      exit={{ opacity: 0 }}
      transition={{ duration: 0.7, delay: 1 }}
    >
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5, delay: 1.5 }}
        className="categories"
        onClick={cycleOpen}
      >
        <MenuButton isOpen={open} />
        <p>MENU DE CATEGORÍAS</p>
      </motion.div>
      <ButtonViolet />

      <HiddenMenu open={open} action={cycleOpen} />
    </Container>
  )
}

const Container = styled(motion.div)`
  background-color: #bbbbbb;
  color: var(--gray3);
  height: 5rem;
  display: flex;
  align-items: center;
  position: relative;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  justify-content: space-between;
  .categories {
    padding: 0rem 4rem;
    user-select: none;
    display: flex;
    gap: 10px;
    cursor: pointer;
    align-items: center;
    height: 100%;

    p {
      font-weight: 700;
      font-size: 16px;
      color: #454545;
    }
  }
`
