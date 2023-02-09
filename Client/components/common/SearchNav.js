import styled from 'styled-components'
import { motion } from 'framer-motion'
import SearchIcon from '@/public/icons/Search'

export const SearchNav = () => {
  return (
    <ContainerInput>
      <Input
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5, delay: 0.5 }}
        placeholder="Buscar..."
      />
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5, delay: 1 }}
        className="icon-container"
      >
        <SearchIcon />
      </motion.div>
    </ContainerInput>
  )
}

const ContainerInput = styled.div`
  width: 57rem;
  display: flex;
  align-items: center;
  position: relative;
  .icon-container {
    background: var(--primaryGreen1);
    cursor: pointer;
    position: absolute;
    right: 0.5rem;
    border-radius: 10px;
    height: 4.4rem;
    width: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
  }
`
const Input = styled(motion.input)`
  height: 4.2rem;
  width: 100%;
  background-color: #fff;
  box-shadow: none;
  border: none;
  color: var(--secondaryViolet1);
  padding: 2.5rem 1.5rem;
  border-radius: 10px;
  font-family: Raleway;
  font-size: 16px;
  transition: all ease-in-out 0.3s;
  &:focus {
    outline: none;
    box-shadow: 0 0 6px 1px #01f603;
  }
`
