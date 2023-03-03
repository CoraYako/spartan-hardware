/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  compiler: {
    styledComponents: true,
  },
  images: {
    domains: ['ecommerce.spartan.images.s3.us-east-2.amazonaws.com'],
  },
}

module.exports = nextConfig
