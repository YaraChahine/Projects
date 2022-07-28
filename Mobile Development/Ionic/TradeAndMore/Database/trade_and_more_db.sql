-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2022 at 07:52 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trade_and_more_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `bids`
--

CREATE TABLE `bids` (
  `bid_id` int(11) NOT NULL,
  `bidder_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_price` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bids_notifications`
--

CREATE TABLE `bids_notifications` (
  `bids_notifications_id` int(11) NOT NULL,
  `bidder_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_price` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `category_name`) VALUES
(1, 'Vehicles'),
(2, 'Fashion'),
(3, 'Appliances'),
(4, 'Furniture'),
(5, 'Electronics'),
(6, 'Hobbies'),
(7, 'Sports'),
(8, 'Other');

-- --------------------------------------------------------

--
-- Table structure for table `categories_and_subcategories`
--

CREATE TABLE `categories_and_subcategories` (
  `category_id` int(11) NOT NULL,
  `subcategory_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories_and_subcategories`
--

INSERT INTO `categories_and_subcategories` (`category_id`, `subcategory_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(3, 13),
(4, 14),
(4, 15),
(4, 16),
(4, 17),
(4, 18),
(4, 19),
(5, 20),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(6, 25),
(6, 26),
(6, 27),
(6, 28),
(7, 29),
(7, 30);

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `message_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `message` text NOT NULL,
  `time_sent` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `review` varchar(255) NOT NULL,
  `rating` float NOT NULL,
  `feedback_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `followers`
--

CREATE TABLE `followers` (
  `followedby` int(11) NOT NULL,
  `follows` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_image` varchar(255) NOT NULL,
  `item_category` int(11) NOT NULL,
  `item_subcategory` int(11) NOT NULL,
  `item_description` varchar(255) NOT NULL,
  `item_type` int(11) NOT NULL,
  `item_price` int(11) NOT NULL,
  `date_uploaded` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `items_bid`
--

CREATE TABLE `items_bid` (
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_image` varchar(255) NOT NULL,
  `item_category` int(11) NOT NULL,
  `item_subcategory` int(11) NOT NULL,
  `item_description` varchar(255) NOT NULL,
  `item_price` int(11) NOT NULL,
  `date_uploaded` timestamp NOT NULL DEFAULT current_timestamp(),
  `is_active` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `items_on_bid`
--

CREATE TABLE `items_on_bid` (
  `bid_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `date_and_time` datetime NOT NULL DEFAULT current_timestamp(),
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pending_requests`
--

CREATE TABLE `pending_requests` (
  `pending_request_id` int(11) NOT NULL,
  `sender_user_id` int(11) NOT NULL,
  `receiver_user_id` int(11) NOT NULL,
  `sender_item_id` int(11) DEFAULT NULL,
  `receiver_item_id` int(11) NOT NULL,
  `requested_item_price` int(11) NOT NULL,
  `request_msg` varchar(400) NOT NULL,
  `request_date` datetime NOT NULL DEFAULT current_timestamp(),
  `request_status` int(11) NOT NULL DEFAULT 0,
  `review_written` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `receipts`
--

CREATE TABLE `receipts` (
  `receipt_id` int(11) NOT NULL,
  `sender_user_id` int(11) NOT NULL,
  `sender_name` varchar(255) NOT NULL,
  `sender_email` varchar(255) NOT NULL,
  `sender_phone_number` varchar(255) NOT NULL,
  `sender_photo` varchar(255) NOT NULL,
  `receiver_user_id` int(11) NOT NULL,
  `receiver_name` varchar(255) NOT NULL,
  `receiver_email` varchar(255) NOT NULL,
  `receiver_phone_number` varchar(255) NOT NULL,
  `receiver_photo` varchar(255) NOT NULL,
  `exchange_type_id` int(11) NOT NULL,
  `exchange_type_name` varchar(255) NOT NULL,
  `sender_item_id` int(11) NOT NULL,
  `sender_item_name` varchar(255) NOT NULL,
  `sender_item_image` varchar(255) NOT NULL,
  `receiver_item_id` int(11) NOT NULL,
  `receiver_item_name` varchar(255) NOT NULL,
  `receiver_item_image` varchar(255) NOT NULL,
  `receiver_item_price` int(11) NOT NULL,
  `request_date` datetime NOT NULL,
  `receipt_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subcategories`
--

CREATE TABLE `subcategories` (
  `subcategory_id` int(11) NOT NULL,
  `subcategory_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subcategories`
--

INSERT INTO `subcategories` (`subcategory_id`, `subcategory_name`) VALUES
(1, 'Cars'),
(2, 'Motorcycles'),
(3, 'Clothes For Men'),
(4, 'Clothes For Women'),
(5, 'Clothes For Kids'),
(6, 'Accessories For Men'),
(7, 'Accessories For Women'),
(8, 'Accessories For Kids'),
(9, 'Kitchen'),
(10, 'Garden'),
(11, 'Office'),
(12, 'Beauty'),
(13, 'Cleaning'),
(14, 'Living Room'),
(15, 'Bedroom'),
(16, 'Dining Room'),
(17, 'Bathroom'),
(18, 'Outdoor'),
(19, 'Decorations'),
(20, 'TV'),
(21, 'Mobile Phones & Tablets'),
(22, 'PCs & Laptops'),
(23, 'Gaming Consoles'),
(24, 'Accessories'),
(25, 'Books'),
(26, 'Arts'),
(27, 'Music'),
(28, 'Crafts'),
(29, 'Gym Equipment'),
(30, 'Ball Sports'),
(31, 'Other');

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE `types` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`type_id`, `type_name`) VALUES
(1, 'Trade'),
(2, 'For Sale'),
(3, 'For Trade Or For Sale'),
(4, 'For Trade and For Sale'),
(5, 'Donation');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `wishlist` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `rating` float NOT NULL,
  `number_of_posts` int(11) NOT NULL,
  `trades_sales_counter` int(11) NOT NULL DEFAULT 0,
  `donations_counter` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bids`
--
ALTER TABLE `bids`
  ADD PRIMARY KEY (`bid_id`),
  ADD KEY `foreignkey24` (`item_id`),
  ADD KEY `foreignkey23` (`bidder_id`);

--
-- Indexes for table `bids_notifications`
--
ALTER TABLE `bids_notifications`
  ADD PRIMARY KEY (`bids_notifications_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `categories_and_subcategories`
--
ALTER TABLE `categories_and_subcategories`
  ADD PRIMARY KEY (`subcategory_id`),
  ADD KEY `categories_and_subcategories_ibfk_2` (`category_id`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `foreignkeyyy` (`receiver_id`),
  ADD KEY `foreignkeyyyyy` (`sender_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `14` (`sender_id`),
  ADD KEY `15` (`receiver_id`);

--
-- Indexes for table `followers`
--
ALTER TABLE `followers`
  ADD KEY `followers_ibfk_1` (`followedby`),
  ADD KEY `followers_ibfk_2` (`follows`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `items_ibfk_1` (`user_id`),
  ADD KEY `items_ibfk_2` (`item_category`),
  ADD KEY `items_ibfk_3` (`item_subcategory`),
  ADD KEY `items_ibfk_4` (`item_type`);

--
-- Indexes for table `items_bid`
--
ALTER TABLE `items_bid`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `frrr` (`user_id`),
  ADD KEY `frfr` (`item_category`),
  ADD KEY `frrrre` (`item_subcategory`);

--
-- Indexes for table `items_on_bid`
--
ALTER TABLE `items_on_bid`
  ADD PRIMARY KEY (`bid_id`),
  ADD KEY `FK1bids` (`user_id`),
  ADD KEY `FK2bids` (`item_id`);

--
-- Indexes for table `pending_requests`
--
ALTER TABLE `pending_requests`
  ADD PRIMARY KEY (`pending_request_id`),
  ADD KEY `fr key1` (`sender_user_id`),
  ADD KEY `fr key2` (`receiver_user_id`);

--
-- Indexes for table `receipts`
--
ALTER TABLE `receipts`
  ADD PRIMARY KEY (`receipt_id`),
  ADD KEY `a1` (`sender_user_id`),
  ADD KEY `a2` (`receiver_user_id`),
  ADD KEY `a3` (`exchange_type_id`);

--
-- Indexes for table `subcategories`
--
ALTER TABLE `subcategories`
  ADD PRIMARY KEY (`subcategory_id`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bids`
--
ALTER TABLE `bids`
  MODIFY `bid_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bids_notifications`
--
ALTER TABLE `bids_notifications`
  MODIFY `bids_notifications_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `items_bid`
--
ALTER TABLE `items_bid`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `items_on_bid`
--
ALTER TABLE `items_on_bid`
  MODIFY `bid_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pending_requests`
--
ALTER TABLE `pending_requests`
  MODIFY `pending_request_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `receipts`
--
ALTER TABLE `receipts`
  MODIFY `receipt_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subcategories`
--
ALTER TABLE `subcategories`
  MODIFY `subcategory_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bids`
--
ALTER TABLE `bids`
  ADD CONSTRAINT `foreignkey23` FOREIGN KEY (`bidder_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `foreignkey24` FOREIGN KEY (`item_id`) REFERENCES `items_bid` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `categories_and_subcategories`
--
ALTER TABLE `categories_and_subcategories`
  ADD CONSTRAINT `categories_and_subcategories_ibfk_1` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategories` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categories_and_subcategories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `foreignkeyyy` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `foreignkeyyyyy` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `14` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `15` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `followers`
--
ALTER TABLE `followers`
  ADD CONSTRAINT `followers_ibfk_1` FOREIGN KEY (`followedby`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `followers_ibfk_2` FOREIGN KEY (`follows`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `items_ibfk_2` FOREIGN KEY (`item_category`) REFERENCES `categories_and_subcategories` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `items_ibfk_3` FOREIGN KEY (`item_subcategory`) REFERENCES `categories_and_subcategories` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `items_ibfk_4` FOREIGN KEY (`item_type`) REFERENCES `types` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `items_bid`
--
ALTER TABLE `items_bid`
  ADD CONSTRAINT `frfr` FOREIGN KEY (`item_category`) REFERENCES `categories` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `frrr` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `frrrre` FOREIGN KEY (`item_subcategory`) REFERENCES `subcategories` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `items_on_bid`
--
ALTER TABLE `items_on_bid`
  ADD CONSTRAINT `FK1bids` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK2bids` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pending_requests`
--
ALTER TABLE `pending_requests`
  ADD CONSTRAINT `fr key1` FOREIGN KEY (`sender_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fr key2` FOREIGN KEY (`receiver_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `receipts`
--
ALTER TABLE `receipts`
  ADD CONSTRAINT `a1` FOREIGN KEY (`sender_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a2` FOREIGN KEY (`receiver_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a3` FOREIGN KEY (`exchange_type_id`) REFERENCES `types` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
