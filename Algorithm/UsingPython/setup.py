import setuptools

with open("README.md", "r") as f:
    project_read_me = f.read()

with open('LICENSE') as f:
    project_license = f.read()

setuptools.setup(
    name="basic_algorithm",
    version="1.0.0",
    author="Kim Kuhyun",
    author_email="dreamx119@gmail.com",
    description="Algorithm using python",
    long_description=project_read_me,
    license=project_license,
    long_description_content_type="text/markdown",
    url="https://github.com/Rick00Kim/SkillUp_Coding/tree/master/Algorithm/UsingPython",
    packages=setuptools.find_packages(),
    entry_points={
        'console_scripts': ['UsingPython=basic_algorithm.main:main']
    },
    classifiers=[
        "Programming Language :: Python :: 3.8",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
    python_requires='>=3.5',
    zip_safe=False
)
