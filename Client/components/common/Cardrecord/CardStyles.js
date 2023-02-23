import styled from "styled-components";

export const CardWrapper = styled.div`
  display: grid;
  grid-template-columns: 150px 180px;
  grid-template-rows: 20px 200px;
  grid-template-areas: "image" "text" "stats";
  border-radius: 0px;
  background: #EDEDED;
  box-shadow: 5px 5px 15px rgba(4, 4, 4, 0.1);
  text-align: left;
  font-weight: bold;
`;

export const CardImage = styled.div`
  grid-row: 2 / 2;
  grid-column 1 / 1;
  margin-left: 15px;
`; 

export const CardTextWrapper = styled.div`
  grid-area: 2;
  margin: 0px;
  margin-top: 15px;
  
`;

export const CardTextTitle = styled.h2`
  margin-top: 0px;
  font-size: 20px;
  box-sizing: border-box;
  min-width: 0px;
  line-height: 1.2;
  margin: 0px;
  background: linear-gradient(black, black, black);
  -webkit-background-clip: text;
  color: transparent;
`;

export const CardTextBody = styled.p`
  color: grey;
  font-size: 11px;
  font-weight: 300;
  font-weight: bold;
  margin-top: 15px;
`;
