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
      <SearchIcon />
    </ContainerInput>
  )
}

const ContainerInput = styled.div`
  width: 40%;
  display: flex;
  align-items: center;
  position: relative;
  svg {
    cursor: pointer;
    background: var(--primaryGreen1);
    position: absolute;
    right: 1.5rem;
    border-radius: 10px;
  }
`
const Input = styled(motion.input)`
  height: 3rem;
  width: 100%;
  background-color: var(--secondaryViolet2);
  box-shadow: none;
  border: none;
  color: #fff;
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
