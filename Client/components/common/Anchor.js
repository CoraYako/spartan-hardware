import { motion } from 'framer-motion'
import Link from 'next/link'
import styled from 'styled-components'

export const Anchor = ({ text, to }) => {
  return (
    <CustomLink
      whileHover={{
        textDecorationLine: 'none',
        color: '#302544',
        transition: { duration: 0.2 },
      }}
      whileTap={{
        color: '#4d3e6a',
        transition: { duration: 0.2 },
      }}
    >
      <Link passHref href={to}>
        {text}
      </Link>
    </CustomLink>
  )
}

const CustomLink = styled(motion.a)`
  font-family: 'Prompt';
  font-style: normal;
  font-weight: 700;
  font-size: 13px;
  line-height: 16px;
  display: flex;
  align-items: center;
  text-align: center;
  text-decoration-line: underline;
`
