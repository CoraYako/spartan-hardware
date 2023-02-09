import Link from 'next/link'
import styled from 'styled-components'

export const Anchor = ({ text, to }) => {
  return (
    <CustomLink passHref href={to}>
      {text}
    </CustomLink>
  )
}

const CustomLink = styled(Link)`
  font-family: 'Prompt';
  font-style: normal;
  font-weight: 700;
  font-size: 13px;
  line-height: 16px;
  display: flex;
  align-items: center;
  text-align: center;
  text-decoration-line: underline;

  &:hover {
    text-decoration-line: none;
    color: #302544;
  }
`
