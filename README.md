# DeepLearning.AI Code Lab Notebooks for Java World

- Main Source : [DeepLearning.AI website](https://www.deeplearning.ai)
- For Machine Learning Specialization : [Machine Learning Specialization](https://www.deeplearning.ai/specializations/machine-learning)

---

## About This Project

- I use **ND4J** for arrays. ND4J is like NumPy, but for Java.
- I use **Java notebooks** (`.ipynb` or `.ijnb` files). You can run the code step by step, like in Jupyter.
- Why `.ipynb`? Because of **GitHub Preview mode**. GitHub shows `.ipynb` files as notebooks, with the text, the code and the outputs. So you can read the labs on GitHub, without running anything.

> **Note:** This is my personal Java Labs project. It is not an official DeepLearning.AI project.

## What You Need

- **Java 21** (JDK)
- **Maven**
- **VS Code** with the [Oracle Java Platform Extension](https://marketplace.visualstudio.com/items?itemName=Oracle.oracle-java). You need it to open and run the Java notebooks.

## How to Start

1. Download or clone this project.
2. Build the project:

   ```bash
   mvn compile
   ```

   The first build downloads ND4J. It is big, so it can take a few minutes.

3. Open the project folder in VS Code.
4. Open a `.ipynb` file and run the cells one by one.

The notebooks use the Java classes in this project. So please build the project before you run them.

### Not on Windows?

The `pom.xml` file uses ND4J files for **Windows (64-bit) with AVX2**.
On Linux or macOS, change the `nd4j.classifier` value in `pom.xml`. For example:

```xml
<nd4j.classifier>linux-x86_64-avx2</nd4j.classifier>
```

You can also delete the second `nd4j-native` dependency (the one with `<classifier>`). The first one is enough. The second one only makes some operations faster.

## Project Structure

```text
deeplearning_ai_java_code_labs
├── pom.xml
└── src/main/java
    ├── notebooks                               <-- Notebooks (.ipynb or .ijnb)
    │   └── 1_Machine_Learning_Specialization
    │       └── course1/week1
    │           ├── 01_optional_lab_model_representation.ipynb
    │           └── 01_model_representation_2.ipynb
    └── deeplearning_ai                         <-- Java classes for the notebooks
        └── machine_learning_specialization/course1/week1
            ├── SingleVariablePredictFunction.java
            └── ValidateDataSet.java
```

## Labs

### Course 1 — Supervised Machine Learning: Regression and Classification

| Week | Notebook | What is inside? |
|------|----------|-----------------|
| 1 | [01_optional_lab_model_representation.ipynb](src/main/java/notebooks/1_Machine_Learning_Specialization/course1/week1/01_optional_lab_model_representation.ipynb) | Model representation. The notation, a small house price data set (2 samples) and the prediction function `f(x) = w · x + b`. |
| 1 | [01_model_representation_2.ipynb](src/main/java/notebooks/1_Machine_Learning_Specialization/course1/week1/01_model_representation_2.ipynb) | The same model with the `SingleVariablePredictFunction` class. We find `w` and `b` with basic algebra, because 2 points make a line. |

### Java Classes

| Class | What does it do? |
|-------|------------------|
| [SingleVariablePredictFunction](src/main/java/deeplearning_ai/machine_learning_specialization/course1/week1/SingleVariablePredictFunction.java) | Calculates `f(x) = w · x + b` for every value in an array. |
| [ValidateDataSet](src/main/java/deeplearning_ai/machine_learning_specialization/course1/week1/ValidateDataSet.java) | Checks that the feature array and the target array have the same size. It returns the sample count `m`. |

## Python vs Java

This table shows some Python code from the course labs and the same code in this project.

| Python (NumPy) | Java (ND4J) |
|----------------|-------------|
| `import numpy as np` | `import org.nd4j.linalg.factory.Nd4j;` |
| `x = np.array([1.0, 2.0])` | `INDArray x = Nd4j.create(new float[] {1.f, 2.f});` |
| `m = x.shape[0]` | `long m = x.length();` |
| `x[i]` | `x.getFloat(i)` |
| `f = lambda x: w * x + b` | `Function<Float, Float> f = x -> w * x + b;` |

