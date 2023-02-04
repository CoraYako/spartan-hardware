import Link from 'next/link'
import styled from 'styled-components'

export const ButtonViolet = () => {
  return (
    <Container>
      <Link passHref href="#">
        <p> ARMA TU PC</p>
        <div className="gradient" />
      </Link>
    </Container>
  )
}

const Container = styled.div`
  width: 150px;
  margin: auto;
  p {
    position: relative;
    z-index: 5;
    color: #fff;
    font-weight: 700;
    text-align: center;
  }
  .gradient {
    border-top: 40px solid var(--tertiaryNavy1);
    border-left: 25px solid transparent;
    border-right: 25px solid transparent;
    height: 0px;
    margin-right: auto;
    margin-left: auto;
    width: 150px;
    top: 0px;
    position: absolute;
    z-index: 0;
  }
`
