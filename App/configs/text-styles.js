import typography from '../constants/typography'

export default `
  html {
    font-family: ${typography.fontFamily};
    font-size: 10px;
    font-stretch: normal;
    font-style: normal;
    font-variant: normal;
    font-weight: ${typography.fontWeightNormal};
    text-size-adjust: 100%;
  }

  body {
    font-size: ${typography.fontSize3};
    line-height: ${typography.lineHeightNormal}; // Reset CSS override
  }

  h1 {
    font-size: ${typography.fontSize9};
    font-weight: ${typography.fontWeightBold};
  }

  h2 {
    font-size: ${typography.fontSize8};
  }

  h3 {
    font-size: ${typography.fontSize6};
  }

  h4 {
    font-size: ${typography.fontSize5};
  }

  h5 {
    font-size: ${typography.fontSize4};
  }

  h6 {
    font-size: ${typography.fontSize3};
  }
  p {
    font-size: ${typography.fontSize2};
  }

  strong {
    font-weight: ${typography.fontWeightBold};
  }

  @media (max-width: 768px) {

    h1 {
      font-size: ${typography.fontSize7};
    }

    h2 {
      font-size: ${typography.fontSize6};
    }

    h3 {
      font-size: ${typography.fontSize5};
    }

    h4 {
      font-size: ${typography.fontSize4};
    }

    h5 {
      font-size: ${typography.fontSize3};
    }

    h6 {
      font-size: ${typography.fontSize2};
    }
  }
`
