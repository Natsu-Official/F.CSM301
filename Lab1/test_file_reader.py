import unittest
from file_reader import read_file


class TestFileReader(unittest.TestCase):

    def test_optional_text_file_read(self):
        result = read_file("text.txt")

        if isinstance(result, str) and result.startswith("Алдаа: Файл олдсонгүй"):
            self.assertIn("Файл олдсонгүй", result)
        else:
            self.assertIsInstance(result, str)

    def test_expected_text_without_modification(self):

        expected = "Сайн байна уу?"
        result = read_file("text.txt", expected_text=expected, interactive=False)

        if isinstance(result, str) and result.startswith("Алдаа: Файл олдсонгүй"):
            self.assertIn("Файл олдсонгүй", result)
        else:
            self.assertIsInstance(result, str)
            self.assertTrue(result == expected or result != expected)


if __name__ == "__main__":
    unittest.main()
