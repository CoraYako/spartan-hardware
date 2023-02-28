import Image from 'next/image'
import Link from 'next/link'
import styled from 'styled-components'

export const CardTradeMark = ({ image, title, href = '#' }) => {
  return (
    <Link href={href} passHref>
      <CardContainer>
        <div className="top">
          <p>{title}</p>
        </div>
        <Image src={image} alt="logo" placeholder="blur" />
      </CardContainer>
    </Link>
  )
}

const CardContainer = styled.div`
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 616px;
  height: 346px;
  background-color: #fff;
  border-radius: 8px;
  .top {
    border-radius: 8px 8px 0 0;
    color: #fff;
    background-color: #120628;
    width: 100%;
    text-align: center;
    padding: 17px 0;

    p {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 600;
      font-size: 25px;
      line-height: 26px;
    }
  }
  img {
    margin: auto;
  }
  transition: all ease-in-out 0.5s;
  &:hover {
    transform: translateY(-10px);
    box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
  }
`
