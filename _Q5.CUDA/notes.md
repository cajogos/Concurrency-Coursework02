# Question 5 - CUDA

## a) What is the purpose of a GPU and what are some of the ways that a GPU differs from a normal CPU? Contrast and compare performance overheads for CUDA programs versus CPU programs (20 marks)

References:

- https://blogs.nvidia.com/blog/2009/12/16/whats-the-difference-between-a-cpu-and-a-gpu/
- https://www.progamerreview.com/cpu-vs-gpu/

Purpose of GPU:

- Run parallel code.
- Computing for massive parallelism.
- Break complete problems such as graphics processing into thousands or millions of separate tasks and work them out at once.
- Run embarrassingly parallel tasks - deep learning, etc.
  - Pleasingly parallel algorithms

GPU vs CPU:

- GPU good for parallel processing.
- CPU good for serial processing.
- CPU is the brain and GPU is the eyes.
- In gaming a GPU will handle the visual elements, where the CPU will handle the logic and physics (NVIDIA PhysX)
- CPUs run through series of tasks requiring lots of interactivity.
- GPUs break complex problems into thousands or millions of separate task and work them out at once.
  - GPU is ideal for graphics because of it.
- CPU has several cores.
- GPU has many cores.
- CPU has low latency.
- GPU has high throughput.
- CPU can do a handful of operations at once
- GPU can do a thousand of operations at once.

Performance Overheads comparison:

- Cost of CPU-cycles to move data from host to device.
- Some programs will run better in CPU-only environments.
- GPU will speed up programs that require a lot of parallel processing.

## b) Define the terms: Kernel, Thread, Block and how they relate to each other. Give a high level (pseudo code) description of the main steps of the CUDA processing flow (10 marks)

- **Kernel:**
  - Functions that are executed on the GPU.
- **Thread:**
  - Execution of a Kernel with a given index.
  - Each thread uses its index to access elements in an array such that the collection of all threads processes the entire data set.
- **Block:**
  - A group of threads.
  - Can execute concurrently or serially.
  - Threads can be coordinated somewhat using `_synchtreads`.
    - Prevents RAW / WAR / WAW hazards.
- **Grid:**
  - A group of blocks.
  - These is no synchronization at all between blocks.

---

### CUDA Program Flow

1. Allocate host memory (`malloc`) for Array `h_A`.
2. Initialize the Array.
3. Allocate device memory (`cudaMalloc`) for array `d_A`.
   1. `cudaMalloc((void **) &d_A, size)`
4. Transfer data from host to device memory (`cudaMemCpy`).
   1. `cudaMemcpy(d_a, &a, size, cudaMemcpyHostToDevice);`
5. Specify kernel execution Configuration.
   1. Important, depending if its blocks and threads get assigned numbers.
6. Call kernel.
7. Transfer result from device to host memory (`cudaMemCpy`).
   1. `cudaMemcpy(&c, d_c, size, cudaMemcpyDeviceToHost);`
8. Deallocate host (`free`) and device (`cudaFree`) memories.

### Simple Processing Flow

1. Copy input data from CPU memory to GPU memory.
2. Load GPU program and execute, caching data on chip for performance.
3. Copy results from GPU memory to CPU memory.