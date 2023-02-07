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
    font-size: ${typography.fontSize4};
    font-weight: ${typography.fontWeightBold};
    line-height: ${typography.lineHeightH1};
  }

  h2 {
    font-size: ${typography.fontSize8};
    font-weight: ${typography.fontWeightBold};
    line-height: ${typography.lineHeightH2};
  }

  h3 {
    font-size: ${typography.fontSize6};
    line-height: ${typography.lineHeightH3};
    font-weight: ${typography.fontWeightSemiBold};
  }

  h4 {
    font-size: ${typography.fontSize5};
    line-height: ${typography.lineHeightH4};
    font-weight: ${typography.fontWeightRegular};
  }

  h5 {
    font-size: ${typography.fontSize4};
    line-height: ${typography.lineHeightH4};
    font-weight: ${typography.fontWeightRegular};
  }

  h6 {
    font-size: ${typography.fontSize3};
    line-height: ${typography.lineHeightH4};
    font-weight: ${typography.fontWeightRegular};
  }
  p {
    font-size: 0.875rem;
    line-height: 1.313rem;
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
